package com.kodilla.sudoku;

public class SudokuElement {
    public static Integer EMPTY = -1;
    private Integer value;


    public SudokuElement() {
        this.value = EMPTY;
    }

    public void setValue(Integer value){
            this.value = value;
    }

    public boolean isEmpty(){
        if (getValue().equals(EMPTY)){
            return true;
        }else{
            return false;
        }
    }

    public Integer getValue() {
        return value;
    }
}
