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
    private FigureColour currentMoveWhite;

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

    public void move(int oldCol, int oldRow, int newCol, int newRow) {
        if (newCol < 0 || newRow < 0 || newRow >= 8 || newCol >= 8 ||
                oldCol < 0 || oldRow < 0 || oldRow >= 8 || oldCol >= 8) {
            System.out.println("Not possible move");
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.BLACK) && (newRow<=oldRow)) {
            System.out.println("Not possible move");
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.WHITE) && (newRow>=oldRow))  {
            System.out.println("Not possible move");
        } else if (oldCol==newCol) {
            System.out.println("Not possible move");
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.BLACK) && (newRow-oldRow > 1)) {
            System.out.println("Not possible move");
        } else if ((getFigure(oldCol, oldRow).getColour() == FigureColour.WHITE) && (oldRow-newRow > 1) )  {
            System.out.println("Not possible move");
        } else {
            Figure figure = getFigure(oldCol, oldRow);
            setFigure(newCol, newRow, figure);
            setFigure(oldCol, oldRow, new None());
            showBoard();
            System.out.println(String.format("Move from %d %d to %d %d", oldCol, oldRow, newCol, newRow));
        }
        if (lastMoveWhite){
            lastMoveWhite = false;
        } else {
            lastMoveWhite = true;
        }
    }

    public void attack(int oldCol, int oldRow, int newCol, int newRow) {
        FigureColour attackingColour = getFigure(oldCol, oldRow).getColour();

        if (newCol < 0 || newRow < 0 || newRow >= 8 || newCol >= 8 ||
                oldCol < 0 || oldRow < 0 || oldRow >= 8 || oldCol >= 8) {
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.BLACK) && (newRow<=oldRow)) {
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.WHITE) && (newRow>=oldRow))  {
            System.out.println("Not possible move");
        } else if (oldCol==newCol) {
            System.out.println("Not possible move");
        } else if (attackingColour == FigureColour.NONE){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow-1).getColour() == attackingColour )){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow-1).getColour() == attackingColour)){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow+1).getColour() == attackingColour)){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow+1).getColour() == attackingColour)){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow-1).getColour() == FigureColour.NONE )){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow-1).getColour() == FigureColour.NONE)){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol > oldCol) && (getFigure(newCol-1, newRow+1).getColour() == FigureColour.NONE)){
            System.out.println("Not possible move");
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol < oldCol) && (getFigure(newCol+1, newRow+1).getColour() == FigureColour.NONE)){
            System.out.println("Not possible move");
        }
        else {
            Figure figure = getFigure(oldCol, oldRow);
            setFigure(newCol, newRow, figure);
            setFigure(oldCol, oldRow, new None());
            if ((attackingColour == FigureColour.WHITE) && (newCol < oldCol)) {
                setFigure(oldCol-1, oldRow-1, new None());
            }
            if ((attackingColour == FigureColour.WHITE) && (newCol > oldCol)) {
                setFigure(oldCol+1, oldRow-1, new None());
            }
            if ((attackingColour == FigureColour.BLACK) && (newCol > oldCol)) {
                setFigure(oldCol+1, oldRow+1, new None());
            }
            if ((attackingColour == FigureColour.BLACK) && (newCol < oldCol)) {
                setFigure(oldCol-1, oldRow+1, new None());
            }
            showBoard();
            System.out.println(String.format("Move from %d %d to %d %d", oldCol, oldRow, newCol, newRow));
        }
        if (lastMoveWhite){
            lastMoveWhite = false;
        } else {
            lastMoveWhite = true;
        }
    }

    public void clickAction(int col, int row) {
        /*currentMoveWhite=getFigure(col,row).getColour();
        if (lastMoveWhite && (currentMoveWhite == FigureColour.WHITE)){
            break;
            jak zakonczyc metode zwracajaca void w tym miejscu, gdy jest true? SWITCH?
        }*/
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

    public void showBoard() {
        //Figure figureWhite = new Figure(FigureColour.WHITE);
        //Figure figureBlack = new Figure(FigureColour.BLACK);

        grid.getChildren().clear(); //a background?

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++){
                Figure figure = getFigure(x, y);
                if (!(figure instanceof None)){

                    ImageView imageView = new ImageView(figure.getImage());
                    grid.add(imageView, x, y);
                    GridPane.setHalignment(imageView, HPos.CENTER);
                    GridPane.setValignment(imageView, VPos.CENTER);
                    //System.out.println("aaNo figure in spot: " + x + ", " + y);
                } else {
                    //System.out.println("No figure in spot: " + x + ", " + y);
                }
            }
        }
        //w petli wyswietlic figury pobierane przez getFigure() na gridzie grid (na poczatku wyczyscic grida za kazdym razem)
    }

    public void initBoard() {

        /*for (int x = 0; x < 8; x++) {
            for (int y =0;y < 8; y++) {
                setFigure(x, y, new Pawn(FigureColour.NONE ));
            }
        }*/

        /*for (int x = 0; x < 8; x++) {
            for (int y =0;y < 8; y++) {
                if(y<=2 && x + y % 2 ==0) {
                    setFigure(x, y, new Pawn(FigureColour.WHITE));
                }
                if(y>4 && x + y % 2 ==0) {
                    setFigure(x, y, new Pawn(FigureColour.BLACK));
                }
            }
        }*/

        setFigure(0, 0, new Pawn(FigureColour.BLACK));
        setFigure(2, 0, new Pawn(FigureColour.BLACK));
        setFigure(4, 0, new Pawn(FigureColour.BLACK));
        setFigure(6, 0, new Pawn(FigureColour.BLACK));
        setFigure(1, 1, new Pawn(FigureColour.BLACK));
        setFigure(3, 1, new Pawn(FigureColour.BLACK));
        setFigure(5, 1, new Pawn(FigureColour.BLACK));
        setFigure(7, 1, new Pawn(FigureColour.BLACK));
        setFigure(0, 2, new Pawn(FigureColour.BLACK));
        setFigure(2, 2, new Pawn(FigureColour.BLACK));
        setFigure(4, 2, new Pawn(FigureColour.BLACK));
        setFigure(6, 2, new Pawn(FigureColour.BLACK));

        setFigure(1, 5, new Pawn(FigureColour.WHITE));
        setFigure(3, 5, new Pawn(FigureColour.WHITE));
        setFigure(5, 5, new Pawn(FigureColour.WHITE));
        setFigure(7, 5, new Pawn(FigureColour.WHITE));
        setFigure(0, 6, new Pawn(FigureColour.WHITE));
        setFigure(2, 6, new Pawn(FigureColour.WHITE));
        setFigure(4, 6, new Pawn(FigureColour.WHITE));
        setFigure(6, 6, new Pawn(FigureColour.WHITE));
        setFigure(1, 7, new Pawn(FigureColour.WHITE));
        setFigure(3, 7, new Pawn(FigureColour.WHITE));
        setFigure(5, 7, new Pawn(FigureColour.WHITE));
        setFigure(7, 7, new Pawn(FigureColour.WHITE));
    }
}
