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


    }

    private static void goThroughFields(int[][] fieldArray) {
        for (int row = 0; row < fieldArray.length; row++) {
            for (int column = 0; column < fieldArray[row].length; column++) {

            }
        }
    }

    private static void checkHorizontal(int[][] fieldArray, int number, int row, int column) {

    }

    private static void checkVertical(int[][] fieldArray, int number, int row, int column) {

    }

    private static boolean checkMoor(int[][] fieldArray, int number, int row, int column) {
        boolean isNotInMoor = false;
        int moorMax = 3;

        int moorNumber = 0;
        int moorRowStart = 0;
        int moorRowEnd = 0;
        int moorColumnStart = 0;
        int moorColumnEnd = 0;
        for (int factor = 1; factor <= moorMax; factor++) {
            for (int moorRow = moorRowStart * factor; moorRow < moorMax * factor; moorRow++) {
                for (int moorColumn = moorRowStart * factor; moorColumn < moorMax * factor; moorColumn++) {

                }
            }
        }

        if (row >= 0 && row < 3 && column >= 0 && column < 3) {
            moorNumber = 1;
            moorStartRow = 0;
            moorEndRow = 3;
            moorStartColumn = 0;
            moorEndColumn = 3;
        } else if (row >= 0 && row < 3 && column >= 3 && column < 6) {

        }
        return isNotInMoor;
    }
}
