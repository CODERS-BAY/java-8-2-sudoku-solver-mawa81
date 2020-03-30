package com.codersbay;

import java.util.Arrays;


public class SudokuSolver {
    public static int[][] field;

    public SudokuSolver(int[][] field) {
        this.field = field;
    }

    public static void viewField(int[][] fieldArray) {
        for (int row = 0; row < fieldArray.length; row++) {
            System.out.println(Arrays.toString(fieldArray[row]));
        }
        System.out.println();
    }

    public static void backtrack(int[][] fieldArray) {
        int[][] tempFieldArray = copy2DArray(fieldArray);
        for (int row = 0; row < tempFieldArray.length; row++) {
            for (int col = 0; col < tempFieldArray[row].length; col++) {
                if (tempFieldArray[row][col] == 0) {
                    for (int number = 1; number <= tempFieldArray[row].length; number++) {
                        //check actual field
                        if (isFieldCorrect(tempFieldArray, number, row, col)) {
                            System.out.println("field" + row + col + number);
                            tempFieldArray[row][col] = number;
                            //check all fields
                            if (checkIfAllFieldsAreCorrect(tempFieldArray)) {
                                System.out.println("allfields" + row + col + number);
                                tempFieldArray[row][col] = number;
                                fieldArray[row][col] = number;
                                break;
                            } else {
                                System.out.println("fault" + row + col + number);
                                tempFieldArray[row][col] = 0;
                            }
                        }

                    }
                }
            }
        }
    }

    public static int[][] copy2DArray(int[][] fieldArray) {
        int[][] tempFieldArray = new int[fieldArray.length][];
        for (int i = 0; i < tempFieldArray.length; ++i) {
            tempFieldArray[i] = Arrays.copyOf(fieldArray[i], fieldArray[i].length);
        }
        return tempFieldArray;
    }

    public static boolean checkIfAllFieldsAreCorrect(int[][] fieldArray) {
        boolean isCorrect = false;
        for (int row = 0; row < fieldArray.length; row++) {
            for (int col = 0; col < fieldArray[row].length; col++) {
                if (fieldArray[row][col] != 0) {
                    int tempNumber = fieldArray[row][col];
                    if (isFieldCorrect(fieldArray, tempNumber, row, col)) {
                        isCorrect = true;
                    } else {
                        isCorrect = false;
                    }
                }
            }
        }
        return isCorrect;
    }

    public static void checkOnes(int[][] fieldArray) {
        boolean checkOnesInField = true;
        while (checkOnesInField) {
            checkOnesInField = SudokuSolver.checkIf_n_NumbersArePossible(fieldArray, 1);
        }
    }

    private static boolean checkIf_n_NumbersArePossible(int[][] fieldArray, int n) {
        boolean checkedAllOnes = false;
        for (int row = 0; row < fieldArray.length; row++) {
            for (int col = 0; col < fieldArray[row].length; col++) {
                if (fieldArray[row][col] == 0) {
                    int countPossibleNumbersPerField = 0;
                    int[] tempNumbers = new int[n];
                    for (int number = 1; number <= fieldArray.length; number++) {
                        if (isFieldCorrect(fieldArray, number, row, col)) {
                            countPossibleNumbersPerField++;
                            tempNumbers[0] = number;
                            // System.out.println(" row= " + row + " col = " + col + " number = " + number +" count= " + countPossibleNumbersPerField);
                        }
                    }
                    if (countPossibleNumbersPerField == n) {
                        if (n == 1) {
                            fieldArray[row][col] = tempNumbers[0];
                        }
                        //System.out.println(" row= " + row + " col = " + col + " number = " + tempNumber);
                        checkedAllOnes = true;
                    }
                }
            }
        }
        field = fieldArray;
        return checkedAllOnes;
    }

    private static boolean isFieldCorrect(int[][] fieldArray, int number, int row, int col) {
        boolean isInHorizon = checkHorizontal(fieldArray, number, row, col);
        boolean isInVertical = checkVertical(fieldArray, number, row, col);
        boolean isInMoor = checkMoor(fieldArray, number, row, col);
        if (isInHorizon && isInVertical && isInMoor) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkHorizontal(int[][] fieldArray, int number, int row, int col) {
        boolean isNotInRow = true;

        for (int i = 0; i < fieldArray[row].length; i++) {
            if (i == col) {
                continue;
            }
            if (fieldArray[row][i] == number) {
                isNotInRow = false;
                break;
            }
            /*else {
                isNotInRow = true;
            }*/
        }
        return isNotInRow;
    }

    private static boolean checkVertical(int[][] fieldArray, int number, int row, int col) {
        boolean isNotInColumn = true;

        for (int i = 0; i < fieldArray.length; i++) {
            if (i == row) {
                continue;
            }
            if (fieldArray[i][col] == number) {
                isNotInColumn = false;
                break;
            }
            /*else {
                isNotInColumn = true;
            }*/
        }
        return isNotInColumn;
    }

    private static boolean checkMoor(int[][] fieldArray, int number, int row, int col) {
        boolean isNotInMoor = true;
        int moorMax = 3;
        int moorNumber = 0;
        int factorRow = 0;
        int factorCol = 0;
        int moorRowStart = 0;
        int moorRowEnd = 3;
        int moorColStart = 0;
        int moorColEnd = 3;

        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            //-------------------------------------------------------------- moor 1
            moorNumber = 1;
            factorRow = 0;
            factorCol = 0;
        } else if (row >= 0 && row < 3 && col >= 3 && col < 6) {
            //-------------------------------------------------------------- moor 2
            moorNumber = 2;
            factorRow = 0;
            factorCol = 3;
        } else if (row >= 0 && row < 3 && col >= 6 && col < 9) {
            //-------------------------------------------------------------- moor 3
            moorNumber = 3;
            factorRow = 0;
            factorCol = 6;
        } else if (row >= 3 && row < 6 && col >= 0 && col < 3) {
            //-------------------------------------------------------------- moor 4
            moorNumber = 4;
            factorRow = 3;
            factorCol = 0;
        } else if (row >= 3 && row < 6 && col >= 3 && col < 6) {
            //-------------------------------------------------------------- moor 5
            moorNumber = 5;
            factorRow = 3;
            factorCol = 3;
        } else if (row >= 3 && row < 6 && col >= 6 && col < 9) {
            //-------------------------------------------------------------- moor 6
            moorNumber = 6;
            factorRow = 3;
            factorCol = 6;
        } else if (row >= 6 && row < 9 && col >= 0 && col < 3) {
            //-------------------------------------------------------------- moor 7
            moorNumber = 7;
            factorRow = 6;
            factorCol = 0;
        } else if (row >= 6 && row < 9 && col >= 3 && col < 6) {
            //-------------------------------------------------------------- moor 8
            moorNumber = 8;
            factorRow = 6;
            factorCol = 3;
        } else if (row >= 6 && row < 9 && col >= 6 && col < 9) {
            //-------------------------------------------------------------- moor 9
            moorNumber = 9;
            factorRow = 6;
            factorCol = 6;
        }

        // for (int factor = 0; factor <= moorMax; factor++) {
        for (int moorRow = moorRowStart + factorRow; moorRow < moorMax + factorRow; moorRow++) {
            for (int moorCol = moorRowStart + factorCol; moorCol < moorMax + factorCol; moorCol++) {

                if (moorRow == row && moorCol == col) {
                    continue;
                }
                if (fieldArray[moorRow][moorCol] == number) {
                    isNotInMoor = false;
                    break;
                }
                /*else {
                    isNotInMoor = true;
                }*/
            }
        }
        // }
        return isNotInMoor;
    }


}
