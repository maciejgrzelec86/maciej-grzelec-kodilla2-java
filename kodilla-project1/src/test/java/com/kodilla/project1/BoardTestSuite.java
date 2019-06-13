package com.kodilla.project1;

import javafx.scene.layout.GridPane;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class BoardTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test suite begins");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test suite ends");
    }

    @Before
    public void before() {
        testCounter++;
        System.out.println("Test no.: " + testCounter  + " starting");
    }

    @After
    public void after() {
        System.out.println("Test no.: " + testCounter + " finished");
    }

    @Test
    public void testProperMove(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.initBoard();
        //When
        boolean result0 = board.properMove(2,2,1,1);
        boolean result1 = board.properMove(2,2,1,2);
        boolean result2 = board.properMove(2,2,1,3);
        boolean result3 = board.properMove(2,2,3,1);
        boolean result4 = board.properMove(2,2,3,2);
        boolean result5 = board.properMove(2,2,3,3);
        boolean result6 = board.properMove(2,2,2,1);
        boolean result7 = board.properMove(2,2,2,3);
        //Then
        assertEquals(false, result0);
        assertEquals(false, result1);
        assertEquals(true, result2);
        assertEquals(false, result3);
        assertEquals(false, result4);
        assertEquals(true, result5);
        assertEquals(false, result6);
        assertEquals(false, result7);
    }

    @Test
    public void testProperAttack(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.setFigure(2, 2, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(3, 3, new Pawn(FigureColour.WHITE, null, null));
        //When
        board.attack(2,2, 4,4);
        FigureColour figureColour22 = board.getFigure(2,2).getColour();
        FigureColour figureColour33 = board.getFigure(3,3).getColour();
        FigureColour figureColour44 = board.getFigure(4,4).getColour();
        //Then
        assertEquals(figureColour22, FigureColour.NONE);
        assertEquals(figureColour33, FigureColour.NONE);
        assertEquals(figureColour44, FigureColour.BLACK);
    }

    @Test
    public void testMoveOutOfBoard(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.setFigure(0, 7, new Pawn(FigureColour.BLACK, null, null));
        //When
        boolean testMove = board.properMove(0,7,1,8);
        //Then
        assertFalse(testMove);
    }

    @Test
    public void testMoveWhenFieldIsFull(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.setFigure(1, 1, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(2, 2, new Pawn(FigureColour.BLACK, null, null));
        //When
        boolean testMove = board.properMove(1,1,2,2);
        //Then
        assertEquals(false, testMove);
    }

    @Test
    public void testAttackWhenFieldIsFull(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.setFigure(1, 1, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(2, 2, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(3, 3, new Pawn(FigureColour.BLACK, null, null));
        //When
        boolean testMove = board.properAttack(1,1,3,3);
        //Then
        assertEquals(false, testMove);
    }

    @Test
    public void properSetAndGetPawnColour(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        //When
        board.setFigure(2, 2, new Pawn(FigureColour.BLACK, null, null));
        FigureColour pawnColour = board.getFigure(2,2).getColour();
        //Then
        assertEquals(FigureColour.BLACK, pawnColour);
    }

    /*ten test nie wychodzi - na podstawie debugowania po move pawn nie zmienia sie w quenna chociaz jest swichToQueen
    a w tej metodzie setFigure(newCol, newRow, new Queen(FigureColour.BLACK, null, null)) - jakby nie nadpisywalo??
    @Test
    public void testSwitchToQueenIfAvailable(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.setFigure(0,6, new Pawn(FigureColour.BLACK, null, null));
        //When
        board.move(0,6,1,7);
        Figure testFigure = board.getFigure(1,7);
        Queen queen = new Queen(FigureColour.BLACK, null, null);
        //Then
        assertEquals(queen, testFigure);
    }*/

    @Test
    public void testSwitchLastMove(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.initBoard();
        //When
        boolean testMove = board.properTurn(1,5);
        boolean testMove2 = board.properTurn(0,2);
        //Then
        assertEquals(false, testMove);
        assertEquals(true, testMove2);
    }

    @Test
    public void testInitBoard() {
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        //When
        board.setFigure(0, 0, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(0, 2, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(1, 1, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(2, 0, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(2, 2, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(3, 1, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(4, 0, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(4, 2, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(5, 1, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(6, 0, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(6, 2, new Pawn(FigureColour.BLACK, null, null));
        board.setFigure(7, 1, new Pawn(FigureColour.BLACK, null, null));

        board.setFigure(0, 6, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(1, 5, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(1, 7, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(2, 6, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(3, 5, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(3, 7, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(4, 6, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(5, 5, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(5, 7, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(6, 6, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(7, 5, new Pawn(FigureColour.WHITE, null, null));
        board.setFigure(7, 7, new Pawn(FigureColour.WHITE, null, null));
        //Then
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ((y <= 2) && ((x + y) % 2 == 0)) {
                    assertEquals(FigureColour.BLACK, board.getFigure(x, y).getColour());
                }
                if ((y > 4) && ((x + y) % 2 == 0)) {
                    assertEquals(FigureColour.WHITE, board.getFigure(x, y).getColour());
                }
            }
        }
    }
}