package com.kodilla.project1;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardRow> rows = new ArrayList<>();
    private final GridPane grid;
    //private final Group pawnGroup = new Group();

    public Board(GridPane grid) {
        this.grid = grid;
        for (int x =0; x < 8; x++) {
            rows.add(new BoardRow());
        }
    }
    //720x720
    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().add(col, figure);
        rows.get(row).getCols().remove(col +1);
    }

    public void showBoard() {

        Figure figureWhite = new Figure(FigureColour.WHITE);
        Figure figureBlack = new Figure(FigureColour.BLACK);

        grid.getChildren().clear();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++){
                if (getFigure(x, y).getColour() == FigureColour.WHITE) {
                    ImageView imageWhite = new ImageView(figureWhite.getImage());
                    grid.add(imageWhite, x, y); // add po getChildren() moze miec tylko jeden indeks?
                } else if (getFigure(x, y).getColour() == FigureColour.BLACK){
                    ImageView imageBlack = new ImageView(figureBlack.getImage());
                    grid.add(imageBlack, x, y);
                } else {
                    System.out.println("No figure in spot: " + x + ", " + y);
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


    //model pamieciowy
    //metody draw / refreach board

}
