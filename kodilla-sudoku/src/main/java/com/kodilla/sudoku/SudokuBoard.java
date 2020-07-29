package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> rows = new ArrayList();
    private int size;

    public SudokuBoard(int size) {
        this.size = size;
        for(int i =0; i < size; i++){
            rows.add(new SudokuRow(size));
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        String board = "";
        for (SudokuRow row: rows){
            for (int i =0; i < size; i++){
                board += " -----";
            }
            board += "\n|";
            for (SudokuElement element: row.getElemntsRow()){
                if(element.getValue() != -1){
                    board += "  ";
                    board += element.getValue();
                    board += "  ";
                }else{
                    board += "     ";
                }
                board += "|";
            }
            board += "\n";
        }
        for (int i =0; i < size; i++){
            board += " -----";
        }
        board += "\n";
        return board;
    }
}
