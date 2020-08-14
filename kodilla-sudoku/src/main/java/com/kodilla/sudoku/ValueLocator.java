package com.kodilla.sudoku;


public class ValueLocator {
    String instruction = "Wprowadź lokalizację oraz liczbę jaką chcesz\n" +
            "w niej umieścić w formacie X,Y,C gdzie:\n" +
            "X - numer kolumny (od 1 do 9) ; Y - numer wiersza (od 1 do 9) ; " +
            "C - cyfra (od 1 do 9) \n";
    int locatedValues = 0;

    private SudokuBoard board;

    protected SudokuBoard locateSudokuElement(SudokuBoard givenBoard, int inputColumnNo, int inputRowNo, Integer val) {
        this.board = givenBoard;
        if (isOK(inputRowNo - 1, inputColumnNo - 1, val)
                && board.getRows().get(inputRowNo - 1).getElemntsRow().get(inputColumnNo - 1).isEmpty()) {
            board.getRows().get(inputRowNo - 1).getElemntsRow().get(inputColumnNo - 1).setValue(val);

            System.out.println(board);
            locatedValues++;
            if (locatedValues == 9) {
                instruction += "Jeśli chcesz aby program rozwiązał Sudoku wpisz 'SUDOKU'\n";
            }
            System.out.println(instruction);
            return board;
        } else {
            System.out.println("Wstawienie cyfry " + val + " w podaną lokalizację nie było możliwe!");
            System.out.println("Pole jest już zajęte lub cyfra " + val + " jest już wpisana w tym rzędzie, kolumnie bądź segmencie");
            System.out.println(instruction);
            return board;
        }
    }


    private boolean isInRow(int rowNo, Integer number) {
        for (SudokuElement thisRowElement : board.getRows().get(rowNo).getElemntsRow()) {
            if (thisRowElement.getValue().equals(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInColumn(int columnNo, Integer number) {
        for (SudokuRow thisRow : board.getRows()) {
            if (thisRow.getElemntsRow().get(columnNo).getValue().equals(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInSegment(int rowNo, int columnNo, Integer number) {
        int segmentStartX = columnNo - columnNo % 3;
        int segmentStartY = rowNo - rowNo % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getRows().get(segmentStartY + i).getElemntsRow().get(segmentStartX + j).getValue().equals(number)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOK(int rowNo, int columnNo, Integer number) {
        return !isInRow(rowNo, number) && !isInColumn(columnNo, number) && !isInSegment(rowNo, columnNo, number);
    }
}
