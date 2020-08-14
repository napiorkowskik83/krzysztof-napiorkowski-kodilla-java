package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    private int columnNo;
    private int rowNo;
    private Integer number;
    SudokuBoard board = new SudokuBoard(9);
    InputValidator inputValidator = new InputValidator();

    public SudokuGame() {

        System.out.println("Witaj w aplikacji rozwiązującej Sudoku");
        System.out.println("Najpierw musisz umieścić kilka cyfr na planszy bo plansza jest pusta: ");
        System.out.println(board);
        System.out.println("Wprowadź lokalizację oraz liczbę jaką chcesz\n" +
                "w niej umieścić w formacie X,Y,C gdzie:\n" +
                "X - numer kolumny (od 1 do 9) ; Y - numer wiersza (od 1 do 9) ; " +
                "C - cyfra (od 1 do 9) \n");

        String input = "";
        Scanner sc = new Scanner(System.in);
        ValueLocator locator = new ValueLocator();
        while (!"SUDOKU".equals(input.toUpperCase())) {
            boolean correctInput = false;
            input = sc.next();
            if (!"SUDOKU".equals(input.toUpperCase())) {
                if (inputValidator.isInputOk(input)) {
                    columnNo = inputValidator.getColumnNo();
                    rowNo = inputValidator.getRowNo();
                    number = inputValidator.getNumber();
                    this.board = locator.locateSudokuElement(board, columnNo, rowNo, number);
                }
            }
        }
        SudokuSolver solver = new SudokuSolver();
        if (solver.solveSudoku(board)) {
            System.out.println("SOLVED!");
            System.out.println(board);
        } else {
            System.out.println("UNSOLVABLE!");
        }
    }
}
