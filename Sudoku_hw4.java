package com.gradescope.cs201;

import java.util.*;

public class Sudoku_hw4 {
    public static int[] find_possible_values(int[][] matrix, int x, int y) {
        if (matrix[x][y] != 0) {
            return new int[0]; // Cell is already filled, no possible values
        }
        
        boolean[] possible = new boolean[10]; // Track possible numbers 1-9
        Arrays.fill(possible, true);
        
        for (int i = 0; i < 9; i++) {
            possible[matrix[x][i]] = false; // Check row
            possible[matrix[i][y]] = false; // Check column
        }
        
        int startRow = (x / 3) * 3;
        int startCol = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                possible[matrix[startRow + i][startCol + j]] = false; // Check 3x3 subgrid
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int num = 1; num <= 9; num++) {
            if (possible[num]) {
                result.add(num);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void solve(int[][] matrix) {
        backtrack(matrix);
    }

    private static boolean backtrack(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(matrix, i, j, num)) {
                            matrix[i][j] = num;
                            if (backtrack(matrix)) {
                                return true;
                            }
                            matrix[i][j] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found, trigger backtracking
                }
            }
        }
        return true; // Sudoku solved
    }

    private static boolean isValid(int[][] matrix, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
