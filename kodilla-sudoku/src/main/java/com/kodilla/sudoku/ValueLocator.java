package com.kodilla.sudoku;


public class ValueLocator {
    String instruction = "Wprowadź lokalizację oraz liczbę jaką chcesz\n" +
            "w niej umieścić w formacie X,Y,C gdzie:\n" +
            "X - numer kolumny (od 1 do 9) ; Y - numer wiersza (od 1 do 9) ; " +
            "C - cyfra (od 1 do 9) \n";
    int locatedValues = 0;

    protected SudokuBoard locateSudokuElement(SudokuBoard board, int x, int y, Integer val){
        boolean locationSucceed = board.getRows().get(y-1).getElemntsRow().get(x-1).setValue(val);
        if(!locationSucceed){
            System.out.println("Wstawienie cyfry " + val + " w podaną lokalizację nie było możliwe!");
            System.out.println("Pole jest już zajęte lub cyfra " + val + " jest już wpisana w tym rzędzie, kolumnie bądź segmencie");
            System.out.println(instruction);
            return board;
        }else{
            updateAllowedValues(board,  x, y, val);
            System.out.println(board);
            locatedValues++;
            if (locatedValues == 9) {
                instruction += "Jeśli chcesz aby program rozwiązał Sudoku wpisz 'SUDOKU'\n";
            }
            System.out.println(instruction);
            return board;
        }
    }

    private void updateAllowedValues(SudokuBoard board, int x, int y, Integer val){
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
        }else if (y > 6) {
            segmentStartY = 6;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board.getRows().get(segmentStartY + i).getElemntsRow().get(segmentStartX + j).removeFromAllowedValues(val);
            }
        }
    }
}
