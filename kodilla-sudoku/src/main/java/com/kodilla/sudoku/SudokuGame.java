package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuGame {
    private int x;
    private int y;
    private Integer value;
    SudokuBoard board = new SudokuBoard(9);

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
                    board = locator.locateSudokuElement(board, x, y, value);
                }
            }
        }
        try {
            solveSudoku();
        } catch (Exception e) {
            System.out.println("solveSudoku failed");
            e.printStackTrace();
        }
    }
    private void solveSudoku() throws Exception {
        boolean fillInResult = false;
        for(int rowNo = 0; rowNo < 9; rowNo++){
            SudokuRow row = board.getRows().get(rowNo);
            for(int columnNo = 0; columnNo < 9; columnNo++){
                SudokuElement element =  row.getElemntsRow().get(columnNo);
                boolean locationSucceed = false;
                if(element.getValue().equals(-1)){
                    for(SudokuElement sameRowElement: row.getElemntsRow()) {
                        fillInResult = fillInProcedure(element, sameRowElement);
                    }

                    for(int k = 0; k < 9; k++){
                        SudokuElement sameColumnElement = board.getRows().get(k).getElemntsRow().get(columnNo);
                        fillInResult = fillInProcedure(element, sameColumnElement);
                    }
                    
                    int segmentStartX = 0;
                    int segmentStartY = 0;
                    if(columnNo > 3 && columnNo < 7){
                        segmentStartX = 3;
                    }else if (columnNo > 6) {
                        segmentStartX = 6;
                    }
                    if(rowNo  >3 && rowNo < 7){
                        segmentStartY = 3;
                    }else if (rowNo > 6) {
                        segmentStartY = 6;
                    }
                    for(int l = 0; l < 3; l++){
                        for(int m = 0; m < 3; m++){
                            SudokuElement sameSegmentElement = board.getRows().get(segmentStartY + m).getElemntsRow().get(segmentStartX + l);
                            fillInResult = fillInProcedure(element, sameSegmentElement);
                        }
                    }
                }
            }
        }

        System.out.println(board);
    }

    private boolean fillInProcedure(SudokuElement element, SudokuElement sameAreaElement) throws Exception {
        boolean locationSucceed = false;
        List<Integer> copiedPossibleValues = new ArrayList<>(element.getAllowedValues());
        if(!element.equals(sameAreaElement)){
            for(Integer possibleValue: element.getAllowedValues()) {
                if (possibleValue.equals(sameAreaElement.getValue())) {
                    copiedPossibleValues.remove(possibleValue);
                    if(copiedPossibleValues.size()==1){
                        element.setValue(copiedPossibleValues.get(0));
                        locationSucceed = true;
                    }
                }else if(!possibleValue.equals(sameAreaElement.getValue())
                        && !sameAreaElement.getAllowedValues().contains(possibleValue)){
                    element.setValue(possibleValue);
                    locationSucceed =true;
                }else if(possibleValue.equals(sameAreaElement.getValue()) &&
                        element.getAllowedValues().size() == 0){
                    throw new Exception();
                }
            }
            element.setAllowedValues(copiedPossibleValues);
        }
        return locationSucceed;
    }
}
