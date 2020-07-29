package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    int x;
    int y;
    int l;
    Scanner sc;
    private final SudokuBoard board = new SudokuBoard(9);;

    public SudokuGame() {
        sc = new Scanner(System.in);
        System.out.println("Witaj w aplikacji rozwiązującej Sudoku");
        System.out.println("Najpierw musisz umieścić kilka liczb na planszy.");
        System.out.println(board);
        String instruction = "Wprowadź lokalizację oraz liczbę jaką chcesz\n" +
                "w niej umieścić w formacie X,Y,L gdzie:\n" +
                "X - numer kolumny (od 1 do 9) ; Y - numer wiersza (od 1 do 9) ; " +
                "L - liczba (od 1 do 9) \n";

        String input = "";
        int n;
        while(!"SUDOKU".equals(input.toUpperCase())){
            if(n==5){
                instruction += "Jeśli chcesz aby program rozwiązał Sudoku wpisz 'SUDOKU'\n";
            }
            System.out.println(instruction);
            boolean correctInput = false;
            input = sc.next();
            if(!"SUDOKU".equals(input.toUpperCase())){
                try{
                    x = Integer.parseInt(input.substring(0,1));
                    y = Integer.parseInt(input.substring(2,3));
                    l = Integer.parseInt(input.substring(4,5));
                    if (x > 0 && x < 10 && y > 0 && y < 10 && l > 0 && l < 10) {
                        correctInput = true;
                    }
                }catch (Exception e){
                    System.out.println("Wprowadziłeś niepoprawne dane!");
                }
                if(correctInput){
                    boolean locationSucceed = locateSudokuElement(x, y, l);
                    if (locationSucceed) {
                        n++;
                        System.out.println(board);
                    }
                }
            }
        }

    }
    private boolean locateSudokuElement(int x, int y, int l){
        boolean locationSucceed = board.getRows().get(y-1).getRow().get(x-1).setValue(l);
        if(!locationSucceed){
            System.out.println("Wstawienie cyfry " + l + " w podaną lokalizację nie było możliwe!");
            return false;
        }else{
            return true;
        }
    }
}
