package ru.skrser.ctci1dot7;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergey Skryabin
 * on 03.01.2017.
 */
public class Solution {

    /**
     * Set 0 value in rows and columns of N*M matrix, if theirs intersection contains 0.
     * Computational complexity = O(N*M)
     * Memory consumption = O(N+M)
     *
     * @param matrix to be nulled
     * {@link ArrayIndexOutOfBoundsException} could be thrown, if given multidimensional array is ragged
     */
    public static void nullingMatrix(int[][] matrix) {
        if (matrix == null)
            return;

        Set<Integer> nullableRows = new HashSet<Integer>();
        Set<Integer> nullableColumns = new HashSet<Integer>();

        findNullableRowsAndColumns(matrix, nullableRows, nullableColumns);

        for (Integer nullableRow : nullableRows) {
            for (int j = 0; j < matrix[nullableRow].length; j++) {
                matrix[nullableRow][j] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (Integer nullableColumn : nullableColumns) {
                matrix[i][nullableColumn] = 0;
            }
        }
    }

    private static void findNullableRowsAndColumns(int[][] matrix, Set<Integer> nullableRows, Set<Integer> nullableColumns) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    nullableRows.add(i);
                    nullableColumns.add(j);
                }
            }
        }
    }

}
