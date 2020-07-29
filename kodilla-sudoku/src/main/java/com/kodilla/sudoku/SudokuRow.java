package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> row = new ArrayList();

    public SudokuRow(int elementsNo) {
        for (int i = 0 ; i < elementsNo; i++){
            row.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getRow() {
        return row;
    }
}
