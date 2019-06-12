package com.kodilla.project1;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardRow> rows = new ArrayList<>();
    private final GridPane grid;
    private final Image blackPawn;
    private final Image whitePawn;
    private int col1 = -1;
    private int row1 = -1;
    private boolean lastMoveWhite = true;
    private int sumWhite = 0;
    private int sumBlack = 0;

    public Board(GridPane grid, Image blackPawn, Image whitePawn) {
        this.grid = grid;
        this.blackPawn = blackPawn;
        this.whitePawn = whitePawn;
        for (int x = 0; x < 8; x++) {
            rows.add(new BoardRow());
        }
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().add(col, figure);
        rows.get(row).getCols().remove(col + 1);
    }

    public boolean properTurn(int oldCol, int oldRow) {
        if ((lastMoveWhite && (getColour(oldCol, oldRow) == FigureColour.BLACK)) ||
                !(lastMoveWhite) && (getColour(oldCol, oldRow) == FigureColour.WHITE)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean properMove(int oldCol, int oldRow, int newCol, int newRow) {
        if (newCol < 0 || newRow < 0 || newRow >= 8 || newCol >= 8 ||
                oldCol < 0 || oldRow < 0 || oldRow >= 8 || oldCol >= 8) {
            return false;
        } else if ((getColour(oldCol, oldRow) == FigureColour.BLACK) && (newRow <= oldRow)) {
            return false;
        } else if ((getColour(oldCol, oldRow) == FigureColour.WHITE) && (newRow >= oldRow)) {
            return false;
        } else if (oldCol == newCol) {
            return false;
        } else if ((getColour(oldCol, oldRow) == FigureColour.BLACK) && (newRow - oldRow > 1)) {
            return false;
        } else if ((getColour(oldCol, oldRow) == FigureColour.WHITE) && (oldRow - newRow > 1)) {
            return false;
        } else if (Math.abs(newCol - oldCol) > 1) {
            return false;
        } else if (oldRow == newRow) {
            return false;
        } else {
            return getColour(oldCol, oldRow) != FigureColour.NONE;
        }
    }

    private FigureColour getColour(int oldCol, int oldRow) {
        return getFigure(oldCol, oldRow).getColour();
    }

    public boolean properAttack(int oldCol, int oldRow, int newCol, int newRow) {
        FigureColour attackingColour = getColour(oldCol, oldRow);

        if (newCol < 0 || newRow < 0 || newRow >= 8 || newCol >= 8 ||
                oldCol < 0 || oldRow < 0 || oldRow >= 8 || oldCol >= 8) {
            return false;
        } else if ((attackingColour == FigureColour.BLACK) && (newRow <= oldRow)) {
            return false;
        } else if ((attackingColour == FigureColour.WHITE) && (newRow >= oldRow)) {
            return false;
        } else if (oldCol == newCol) {
            return false;
        } else if (attackingColour == FigureColour.NONE) {
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol > oldCol) && (getColour(newCol - 1, newRow - 1) == attackingColour)) {
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol < oldCol) && (getColour(newCol + 1, newRow - 1) == attackingColour)) {
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol > oldCol) && (getColour(newCol - 1, newRow + 1) == attackingColour)) {
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol < oldCol) && (getColour(newCol + 1, newRow + 1) == attackingColour)) {
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol > oldCol) && (getColour(newCol - 1, newRow - 1) == FigureColour.NONE)) {
            return false;
        } else if ((attackingColour == FigureColour.BLACK) &&
                (newCol < oldCol) && (getColour(newCol + 1, newRow - 1) == FigureColour.NONE)) {
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol > oldCol) && (getColour(newCol - 1, newRow + 1) == FigureColour.NONE)) {
            return false;
        } else if ((attackingColour == FigureColour.WHITE) &&
                (newCol < oldCol) && (getColour(newCol + 1, newRow + 1) == FigureColour.NONE)) {
            return false;
        } else {
            return true;
        }
    }

    public void move(int oldCol, int oldRow, int newCol, int newRow) {
        if (properTurn(oldCol, oldRow) && properMove(oldCol, oldRow, newCol, newRow)) {
            doMove(oldCol, oldRow, newCol, newRow);
            switchToQueenIfAvailable(newCol, newRow, getColour(oldCol, oldRow));
            showBoardAndInfo(oldCol, oldRow, newCol, newRow);
            switchLastMove();
        }
        checkIfGameIsFinished();
    }

    private void showBoardAndInfo(int oldCol, int oldRow, int newCol, int newRow) {
        showBoard();
        System.out.println(String.format("Move from %d %d to %d %d", oldCol, oldRow, newCol, newRow));
    }

    private void doMove(int oldCol, int oldRow, int newCol, int newRow) {
        Figure figure = getFigure(oldCol, oldRow);
        setFigure(newCol, newRow, figure);
        setFigure(oldCol, oldRow, new None());
    }

    private void checkIfGameIsFinished() {
        switch (isGameFinished()) {
            case WHITE:
                System.out.println("White colour wins!!");
                break;
            case BLACK:
                System.out.println("Black colour wins!!");
                break;
        }
    }

    private void switchLastMove() {
        if (lastMoveWhite) {
            lastMoveWhite = false;
        } else {
            lastMoveWhite = true;
        }
    }

    private void switchToQueenIfAvailable(int newCol, int newRow, FigureColour attackingColour) {
        if ((attackingColour == FigureColour.BLACK) && newRow == 7) {
            setFigure(newCol, newRow, new Queen(FigureColour.BLACK));
        }
        if ((attackingColour == FigureColour.WHITE) && newRow == 0) {
            setFigure(newCol, newRow, new Queen(FigureColour.WHITE));
        }
    }

    public void attack(int oldCol, int oldRow, int newCol, int newRow) {
        if (properTurn(oldCol, oldRow) && properAttack(oldCol, oldRow, newCol, newRow)) {
            FigureColour attackingColour = getColour(oldCol, oldRow);
            doMove(oldCol, oldRow, newCol, newRow);
            removeOpponentFigure(oldCol, oldRow, newCol, attackingColour);
            switchToQueenIfAvailable(newCol, newRow, attackingColour);
            showBoardAndInfo(oldCol, oldRow, newCol, newRow);
            switchLastMove();
        }
        checkIfGameIsFinished();
    }

    private void removeOpponentFigure(int oldCol, int oldRow, int newCol, FigureColour attackingColour) {
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
                if (getColour(x, y) == FigureColour.WHITE) {
                    sumWhite = sumWhite + 1;
                }
                if (getColour(x, y) == FigureColour.BLACK) {
                    sumBlack = sumBlack + 1;
                }
            }
        }
        if (sumBlack == 0) {
            return FigureColour.WHITE;
        } else if (sumWhite == 0) {
            return FigureColour.BLACK;
        } else {
            return FigureColour.NONE;
        }
    }

    public void showBoard() {
        grid.getChildren().clear();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Figure figure = getFigure(x, y);
                if (!(figure instanceof None)) {
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
            for (int y = 0; y < 8; y++) {
                if ((y <= 2) && ((x + y) % 2 == 0)) {
                    setFigure(x, y, new Pawn(FigureColour.BLACK, whitePawn, blackPawn));
                }
                if ((y > 4) && ((x + y) % 2 == 0)) {
                    setFigure(x, y, new Pawn(FigureColour.WHITE, whitePawn, blackPawn));
                }
                if ((x + y) % 2 == 1) {
                    setFigure(x, y, new Pawn(FigureColour.NONE, whitePawn, blackPawn));
                }
            }
        }
    }
}
