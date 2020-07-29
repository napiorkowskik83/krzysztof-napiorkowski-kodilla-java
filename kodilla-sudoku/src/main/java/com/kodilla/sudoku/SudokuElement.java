package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value;
    private Set<Integer> allowedValues;

    public SudokuElement() {
        this.value = EMPTY;
        setInitialAllowedValues();

    }

    public boolean setValue(int value){
        if (allowedValues.contains(value)){
            this.value = value;
            allowedValues.remove(value);
            return true;
        }else{
            return false;
        }

    }

    public void removeFromAllowedValues(int value){
        allowedValues.remove(value);
    }

    private void setInitialAllowedValues(){
        allowedValues = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .collect(Collectors.toCollection(HashSet::new));

    }

    public int getValue() {
        return value;
    }

    public Set<Integer> getAllowedValues() {
        return allowedValues;
    }
}
