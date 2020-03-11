package com.codersbay;

public class Main {

    public static void main(String[] args) {
        int[][] sudoku = {{8, 4, 3, 0, 0, 0, 2, 5, 9},
                {6, 7, 9, 2, 0, 5, 8, 3, 1},
                {0, 0, 2, 9, 0, 3, 7, 0, 0},
                {0, 0, 0, 7, 0, 2, 0, 0, 0},
                {5, 0, 6, 4, 0, 9, 1, 0, 7},
                {0, 0, 0, 6, 0, 8, 0, 0, 0},
                {0, 0, 7, 3, 0, 4, 5, 0, 0},
                {3, 6, 8, 5, 0, 7, 9, 1, 4},
                {4, 9, 5, 0, 0, 0, 3, 7, 2}};

        for (int i = 1; i <= 9; i++) {
            goThroughFields(sudoku, i);
        }

    }

    private static int backtracking() {
        return 0;
    }

    private static void goThroughFields(int[][] fieldArray, int number) {
        for (int row = 0; row < fieldArray.length; row++) {
            for (int column = 0; column < fieldArray[row].length; column++) {
                System.out.println(checkHorizontal(fieldArray, number, row, column));
                System.out.println(checkVertical(fieldArray, number, row, column));
                System.out.println(checkMoor(fieldArray, number, row, column));
            }
        }
    }

    private static boolean checkHorizontal(int[][] fieldArray, int number, int row, int column) {
        boolean isNotInRow = false;

        for (int i = 0; i < fieldArray[row].length; i++) {
            if (i == column) {
                continue;
            }
            if (fieldArray[row][i] == number) {
                isNotInRow = false;
            } else {
                isNotInRow = true;
            }
        }
        return isNotInRow;
    }

    private static boolean checkVertical(int[][] fieldArray, int number, int row, int column) {
        boolean isNotInColumn = false;

        for (int i = 0; i < fieldArray.length; i++) {
            if (i == row) {
                continue;
            }
            if (fieldArray[i][column] == number) {
                isNotInColumn = false;
            } else {
                isNotInColumn = true;
            }
        }
        return isNotInColumn;
    }

    private static boolean checkMoor(int[][] fieldArray, int number, int row, int column) {
        boolean isNotInMoor = false;
        int moorMax = 3;
        int moorNumber = 0;
        int factorRow = 0;
        int factorColumn = 0;
        int moorRowStart = 0;
        int moorRowEnd = 3;
        int moorColumnStart = 0;
        int moorColumnEnd = 3;

        if (row >= 0 && row < 3 && column >= 0 && column < 3) {
            //-------------------------------------------------------------- moor 1
            moorNumber = 1;
            factorRow = 0;
            factorColumn = 0;
        } else if (row >= 0 && row < 3 && column >= 3 && column < 6) {
            //-------------------------------------------------------------- moor 2
            moorNumber = 2;
            factorRow = 0;
            factorColumn = 3;
        } else if (row >= 0 && row < 3 && column >= 6 && column < 9) {
            //-------------------------------------------------------------- moor 3
            moorNumber = 3;
            factorRow = 0;
            factorColumn = 6;
        } else if (row >= 3 && row < 6 && column >= 0 && column < 3) {
            //-------------------------------------------------------------- moor 4
            moorNumber = 4;
            factorRow = 3;
            factorColumn = 0;
        } else if (row >= 3 && row < 6 && column >= 3 && column < 6) {
            //-------------------------------------------------------------- moor 5
            moorNumber = 5;
            factorRow = 3;
            factorColumn = 3;
        } else if (row >= 3 && row < 6 && column >= 6 && column < 9) {
            //-------------------------------------------------------------- moor 6
            moorNumber = 6;
            factorRow = 3;
            factorColumn = 6;
        } else if (row >= 6 && row < 9 && column >= 0 && column < 3) {
            //-------------------------------------------------------------- moor 7
            moorNumber = 7;
            factorRow = 6;
            factorColumn = 0;
        } else if (row >= 6 && row < 9 && column >= 3 && column < 6) {
            //-------------------------------------------------------------- moor 8
            moorNumber = 8;
            factorRow = 6;
            factorColumn = 3;
        } else if (row >= 6 && row < 9 && column >= 6 && column < 9) {
            //-------------------------------------------------------------- moor 9
            moorNumber = 9;
            factorRow = 6;
            factorColumn = 6;
        }

        // for (int factor = 0; factor <= moorMax; factor++) {
        for (int moorRow = moorRowStart + factorRow; moorRow < moorMax + factorRow; moorRow++) {
            for (int moorColumn = moorRowStart + factorColumn; moorColumn < moorMax + factorColumn; moorColumn++) {
                System.out.println(row + " " + column + " " + moorRowStart + " " + moorRowEnd + " " + moorColumnStart + " " + moorColumnEnd);
                if (moorRow == row && moorColumn == column) {
                    continue;
                }
                if (fieldArray[moorRow][moorColumn] == number) {
                    isNotInMoor = false;
                } else {
                    isNotInMoor = true;
                }
            }
        }
        // }
        return isNotInMoor;
    }
}
