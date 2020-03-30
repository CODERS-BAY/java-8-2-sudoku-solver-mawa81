package com.codersbay;

public class Main {

    public static void main(String[] args) {
     /*   int[][] sudoku = {{8, 4, 3, 0, 0, 0, 2, 5, 9},
                {6, 7, 9, 2, 0, 5, 8, 3, 1},
                {0, 0, 2, 9, 0, 3, 7, 0, 0},
                {0, 0, 0, 7, 0, 2, 0, 0, 0},
                {5, 0, 6, 4, 0, 9, 1, 0, 7},
                {0, 0, 0, 6, 0, 8, 0, 0, 0},
                {0, 0, 7, 3, 0, 4, 5, 0, 0},
                {3, 6, 8, 5, 0, 7, 9, 1, 4},
                {4, 9, 5, 0, 0, 0, 3, 7, 2}};*/

        int[][] sudoku = {
                {4, 3, 0, 5, 0, 0, 9, 8, 0},
                {0, 0, 0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 4},
                {9, 0, 0, 1, 0, 0, 0, 0, 0},
                {3, 7, 0, 0, 0, 0, 0, 1, 0},
                {6, 4, 0, 2, 0, 0, 0, 7, 0},
                {0, 0, 2, 0, 0, 5, 0, 0, 0},
                {0, 0, 0, 0, 8, 3, 1, 0, 5},
                {0, 8, 0, 0, 0, 0, 4, 0, 0}};

        // Pattern pattern01 = new Pattern(sudoku);
        //   System.out.println(pattern01.toString());

        SudokuSolver sudokuSolver = new SudokuSolver(sudoku);
        System.out.println("original");
        sudokuSolver.viewField(sudoku);


        sudokuSolver.checkOnes(sudoku);
        System.out.println("checked Ones");
        sudokuSolver.viewField(sudoku);
        System.out.println(sudokuSolver.checkIfAllFieldsAreCorrect(sudoku));
        sudokuSolver.backtrack(sudoku);
        sudokuSolver.viewField(sudoku);
      /*  System.out.println("sudoku");
       sudokuSolver.viewField(sudokuSolver.field);
       sudokuSolver.
       // SudokuSolver.checkHorizontal();*/

    }


}


