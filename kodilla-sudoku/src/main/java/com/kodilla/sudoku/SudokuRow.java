package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> elemntsRow;

    public SudokuRow(int elementsNo) {
        elemntsRow = new ArrayList();
        for (int i = 0 ; i < elementsNo; i++){
            elemntsRow.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getElemntsRow() {
        return elemntsRow;
    }
}
