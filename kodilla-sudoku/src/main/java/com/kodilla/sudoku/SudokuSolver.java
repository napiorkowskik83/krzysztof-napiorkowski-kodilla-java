package com.kodilla.sudoku;

public class SudokuSolver {

    public static Integer EMPTY = -1;
    SudokuBoard board;

    public boolean solveSudoku(SudokuBoard board) {
        this.board = board;
        for (int rowNo = 0; rowNo < 9; rowNo++) {
            for (int columnNo = 0; columnNo < 9; columnNo++) {
                SudokuElement element = board.getRows().get(rowNo).getElemntsRow().get(columnNo);
                if (element.isEmpty()) {
                    for (Integer number = 1; number <= 9; number++) {
                        if (isOK(rowNo, columnNo, number)) {
                            element.setValue(number);

                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                element.setValue(EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
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
