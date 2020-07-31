package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value;
    private List<Integer> allowedValues;

    public SudokuElement() {
        this.value = EMPTY;
        setInitialAllowedValues();

    }

    public boolean setValue(int value){
        if (this.value == EMPTY && allowedValues.contains(value)){
            this.value = value;
            //allowedValues.remove(value);
            return true;
        }else{
            return false;
        }
    }


    private void setInitialAllowedValues(){
        allowedValues = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public void setAllowedValues(List<Integer> allowedValues) {
        this.allowedValues = allowedValues;
    }

    public Integer getValue() {
        return value;
    }

    public List<Integer> getAllowedValues() {
        return allowedValues;
    }

    public void removeFromAllowedValues(Integer value){
        allowedValues.remove(value);
    }
}
