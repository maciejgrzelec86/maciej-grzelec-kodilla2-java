package com.kodilla.project1;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardRow> rows = new ArrayList<>();
    private final GridPane grid;
    private int col1 =-1;
    private int row1 =-1;
    private boolean lastMoveWhite = true;
    private int sumWhite = 0;
    private int sumBlack = 0;

    public Board(GridPane grid) {
        this.grid = grid;
        for (int x =0; x < 8; x++) {
            rows.add(new BoardRow());
        }
    }

    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().add(col, figure);
        rows.get(row).getCols().remove(col +1);
    }
    public boolean properTurn(int oldCol, int oldRow) {
        if((lastMoveWhite && (getFigure(oldCol, oldRow).getColour() == FigureColour.BLACK))||
                !(lastMoveWhite) && (getFigure(oldCol, oldRow).getColour() == FigureColour.WHITE)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean properMove(int oldCol, int oldRow, int newCol, int newRow) {
        if (newCol < 0 || newRow < 0 || newRow >= 8 || newCol >= 8 ||
                oldCol < 0 || oldRow < 0 || oldRow >= 8 || oldCol >= 8) {
            return false;
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.BLACK) && (newRow <= oldRow)) {
            return false;
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.WHITE) && (newRow >= oldRow)) {
            return false;
        } else if (oldCol == newCol) {
            return false;
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.BLACK) && (newRow - oldRow > 1)) {
            return false;
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.WHITE) && (oldRow - newRow > 1)) {
            return false;
        } else if (Math.abs(newCol-oldCol)>1) {
            return false;
        } else if (oldCol==newCol && oldRow == newRow) {
            return false;
        }else if (getFigure(oldCol, oldRow).getColour() == FigureColour.NONE) {
            return false;
        } else {
            return true;
        }
    }

    public boolean properAttack (int oldCol, int oldRow, int newCol, int newRow) {
        FigureColour attackingColour = getFigure(oldCol, oldRow).getColour();

        if (newCol < 0 || newRow < 0 || newRow >= 8 || newCol >= 8 ||
                oldCol < 0 || oldRow < 0 || oldRow >= 8 || oldCol >= 8) {
            return false;
        } else if ((attackingColour == FigureColour.BLACK) && (newRow<=oldRow)) {
            return false;
        } else if ((attackingColour == FigureColour.WHITE) && (newRow>=oldRow))  {
            return false;
        } else if (oldCol==newCol) {
            return false;
        } else if (attackingColour == FigureColour.NONE){
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow-1).getColour() == attackingColour )){
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow-1).getColour() == attackingColour)){
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow+1).getColour() == attackingColour)){
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow+1).getColour() == attackingColour)){
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow-1).getColour() == FigureColour.NONE )){
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow-1).getColour() == FigureColour.NONE)){
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow+1).getColour() == FigureColour.NONE)){
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow+1).getColour() == FigureColour.NONE)){
            return false;
        } else {
            return true;
        }
    }

    public void move(int oldCol, int oldRow, int newCol, int newRow) {
        FigureColour attackingColour = getFigure(oldCol, oldRow).getColour();
        if (properTurn(oldCol, oldRow) && properMove(oldCol, oldRow, newCol, newRow)) {
            Figure figure = getFigure(oldCol, oldRow);
            setFigure(newCol, newRow, figure);
            setFigure(oldCol, oldRow, new None());
            showBoard();
            System.out.println(String.format("Move from %d %d to %d %d", oldCol, oldRow, newCol, newRow));
            if (lastMoveWhite){
                lastMoveWhite = false;
            } else {
                lastMoveWhite = true;
            }
            if ((attackingColour == FigureColour.BLACK) && newRow==7) {
                setFigure(newCol, newRow, new Queen(FigureColour.BLACK));
            }
            if ((attackingColour == FigureColour.WHITE) && newRow==0) {
                setFigure(newCol, newRow, new Queen(FigureColour.WHITE));
            }
        }
        switch (isGameFinished()) {
            case WHITE:
                System.out.println("White colour wins!!");
            case BLACK:
                System.out.println("Black colour wins!!");
        }
    }

    public void attack(int oldCol, int oldRow, int newCol, int newRow) {
        FigureColour attackingColour = getFigure(oldCol, oldRow).getColour();
        if (properTurn(oldCol, oldRow) && properAttack(oldCol, oldRow, newCol, newRow)) {
            Figure figure = getFigure(oldCol, oldRow);
            setFigure(newCol, newRow, figure);
            setFigure(oldCol, oldRow, new None());
        if ((attackingColour == FigureColour.WHITE) && (newCol < oldCol)) {
            setFigure(oldCol - 1, oldRow - 1, new None());
        }
        if ((attackingColour == FigureColour.WHITE) && (newCol > oldCol)) {
           setFigure(oldCol + 1, oldRow - 1, new None());
        }
        if ((attackingColour == FigureColour.BLACK) && (newCol > oldCol)) {
           setFigure(oldCol + 1, oldRow + 1, new None());
        }
        if ((attackingColour == FigureColour.BLACK) && (newCol < oldCol)) {
           setFigure(oldCol - 1, oldRow + 1, new None());
        }
        if ((attackingColour == FigureColour.BLACK) && newRow==7) {
                setFigure(newCol, newRow, new Queen(FigureColour.BLACK));
        }
        if ((attackingColour == FigureColour.WHITE) && newRow==0) {
                setFigure(newCol, newRow, new Queen(FigureColour.WHITE));
        }
        showBoard();
        System.out.println(String.format("Move from %d %d to %d %d", oldCol, oldRow, newCol, newRow));

        if (lastMoveWhite) {
           lastMoveWhite = false;
        } else {
           lastMoveWhite = true;
        }
        }
        switch (isGameFinished()){
            case WHITE:
                System.out.println("White colour wins!!");
            case BLACK:
                System.out.println("Black colour wins!!");
        }
    }

    public void clickAction(int col, int row) {
        if (col1 == -1) {
            col1 = col;
            row1 = row;
        } else if (Math.abs(col - col1) == 2) {
            attack(col1, row1, col, row);
            col1 = -1;
        } else {
            move(col1, row1, col, row);
            col1 = -1;
        }
    }

    public FigureColour isGameFinished() {
        sumWhite = 0;
        sumBlack = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (getFigure(x, y).getColour() == FigureColour.WHITE) {
                    sumWhite = sumWhite + 1;
                }
                if (getFigure(x, y).getColour() == FigureColour.BLACK) {
                    sumBlack = sumBlack + 1;
                }
            }
        }
        if (sumBlack==0) {
            return  FigureColour.WHITE;
        } else if (sumWhite==0){
            return  FigureColour.BLACK;
        } else {
            return FigureColour.NONE;
        }
    }

    public void showBoard() {
        grid.getChildren().clear();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++){
                Figure figure = getFigure(x, y);
                if (!(figure instanceof None)){
                    ImageView imageView = new ImageView(figure.getImage());
                    grid.add(imageView, x, y);
                    GridPane.setHalignment(imageView, HPos.CENTER);
                    GridPane.setValignment(imageView, VPos.CENTER);
                }
            }
        }

    }

    public void initBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y =0;y < 8; y++) {
                if((y<=2) && ((x + y) % 2 ==0)) {
                    setFigure(x, y, new Pawn(FigureColour.BLACK));
                }
                if((y>4) && ((x + y) % 2 ==0)) {
                    setFigure(x, y, new Pawn(FigureColour.WHITE));
                }
                if((x + y) % 2 ==1) {
                    setFigure(x, y, new Pawn(FigureColour.NONE));
                }
            }
        }
    }
}
