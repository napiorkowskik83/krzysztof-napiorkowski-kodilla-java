package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    int x;
    int y;
    int value;
    Scanner sc;
    private final SudokuBoard board = new SudokuBoard(9);

    public SudokuGame() {

        sc = new Scanner(System.in);
        System.out.println("Witaj w aplikacji rozwiązującej Sudoku");
        System.out.println("Najpierw musisz umieścić kilka cyfr na planszy bo plansza jest pusta: ");
        System.out.println(board);
        String instruction = "Wprowadź lokalizację oraz liczbę jaką chcesz\n" +
                "w niej umieścić w formacie X,Y,C gdzie:\n" +
                "X - numer kolumny (od 1 do 9) ; Y - numer wiersza (od 1 do 9) ; " +
                "C - cyfra (od 1 do 9) \n";

        String input = "";
        int n = 0;
        while (!"SUDOKU".equals(input.toUpperCase())) {
            if (n == 5) {
                instruction += "Jeśli chcesz aby program rozwiązał Sudoku wpisz 'SUDOKU'\n";
            }
            System.out.println(instruction);
            boolean correctInput = false;
            input = sc.next();
            if (!"SUDOKU".equals(input.toUpperCase())) {
                try {
                    x = Integer.parseInt(input.substring(0, 1));
                    y = Integer.parseInt(input.substring(2, 3));
                    value = Integer.parseInt(input.substring(4, 5));
                    if (x > 0 && x < 10 && y > 0 && y < 10 && value > 0 && value < 10) {
                        correctInput = true;
                    }
                } catch (Exception e) {
                    System.out.println("Wprowadziłeś niepoprawne dane!");
                }
                if (correctInput) {
                    boolean isLocationSucceed = locateSudokuElement(x, y, value);
                    if (isLocationSucceed) {
                    }
                    n++;
                    System.out.println(board);
                }
            }
        }
    }

    private boolean locateSudokuElement(int x, int y, int val){
        boolean locationSucceed = board.getRows().get(y-1).getElemntsRow().get(x-1).setValue(val);
        if(!locationSucceed){
            System.out.println("Wstawienie cyfry " + val + " w podaną lokalizację nie było możliwe!");
            System.out.println("Cyfra " + val + " jest już wpisana w tym rzędzie, kolumnie bądź segmencie");
            return false;
        }else{
            updateAllowedValues(x, y, val);
            return true;
        }
    }

    private void updateAllowedValues(int x, int y, int val){
        for(SudokuElement element: board.getRows().get(y-1).getElemntsRow()){
            element.removeFromAllowedValues(val);
        }
        for (SudokuRow row: board.getRows()){
            row.getElemntsRow().get(x-1).removeFromAllowedValues(val);
        }
        int segmentStartX = 0;
        int segmentStartY = 0;
        if(x > 3 && x < 7){
            segmentStartX = 3;
        }else if (x > 6) {
            segmentStartX = 6;
        }
        if(y>3 && y < 7){
            segmentStartY = 3;
        }else if (x > 6) {
            segmentStartY = 6;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board.getRows().get(segmentStartY + i).getElemntsRow().get(segmentStartX + j).removeFromAllowedValues(val);
            }
        }
    }
}
