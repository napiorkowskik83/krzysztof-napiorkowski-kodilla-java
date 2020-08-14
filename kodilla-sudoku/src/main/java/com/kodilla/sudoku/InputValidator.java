package com.kodilla.sudoku;

public class InputValidator {
    int columnNo;
    int rowNo;
    Integer number;

    public int getColumnNo() {
        return columnNo;
    }

    public int getRowNo() {
        return rowNo;
    }

    public Integer getNumber() {
        return number;
    }

    public boolean isInputOk(String input) {
        boolean correctInput = false;
        try {
            columnNo = Integer.parseInt(input.substring(0, 1));
            rowNo = Integer.parseInt(input.substring(2, 3));
            number = Integer.parseInt(input.substring(4, 5));
            if (columnNo > 0 && columnNo <= 9 && rowNo > 0 && rowNo <= 9 && number > 0 && number <= 9) {
                correctInput = true;
                if (!correctInput) {
                    System.out.println("Wprowadziłeś niepoprawne dane!");
                }
            }
        } catch (Exception e) {
            System.out.println("Wprowadziłeś niepoprawne dane!");
        }
        return correctInput;
    }
}
