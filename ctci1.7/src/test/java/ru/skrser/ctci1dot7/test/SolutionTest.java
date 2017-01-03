package ru.skrser.ctci1dot7.test;

import org.junit.Test;
import ru.skrser.ctci1dot7.Solution;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sergey Skryabin
 * on 03.01.2017.
 */
public class SolutionTest {

    @Test
    public void testNull() {
        Solution.nullingMatrix(null);
    }

    @Test
    public void test1x1NotNull() {
        int[][] originalMatrix = {{1}};
        final int[][] nulledMatrix = {{1}};
        Solution.nullingMatrix(originalMatrix);
        assertArrayEquals(nulledMatrix, originalMatrix);
    }

    @Test
    public void test1x1Null() {
        int[][] originalMatrix = {{0}};
        final int[][] nulledMatrix = {{0}};
        Solution.nullingMatrix(originalMatrix);
        assertArrayEquals(nulledMatrix, originalMatrix);
    }

    @Test
    public void test2x2NotNull() {
        int[][] originalMatrix = {{1, 2},
                                  {3, 4}};
        int[][] nulledMatrix = {{1, 2},
                                {3, 4}};
        Solution.nullingMatrix(originalMatrix);
        assertArrayEquals(nulledMatrix, originalMatrix);
    }

    @Test
    public void test2x2Null() {
        int[][] originalMatrix = {{1, 0},
                                  {3, 4}};
        int[][] nulledMatrix = {{0, 0},
                                {3, 0}};
        Solution.nullingMatrix(originalMatrix);
        assertArrayEquals(nulledMatrix, originalMatrix);
    }

    @Test
    public void test3x3Null() {
        int[][] originalMatrix = {{1, 2, 3},
                                  {4, 0, 6},
                                  {7, 8, 9}};
        int[][] nulledMatrix = {{1, 0, 3},
                                {0, 0, 0},
                                {7, 0, 9}};
        Solution.nullingMatrix(originalMatrix);
        assertArrayEquals(nulledMatrix, originalMatrix);
    }

    @Test
    public void test3x3NullCross() {
        int[][] originalMatrix = {{0, 2, 3},
                                  {4, 5, 6},
                                  {7, 8, 0}};
        int[][] nulledMatrix = {{0, 0, 0},
                                {0, 5, 0},
                                {0, 0, 0}};
        Solution.nullingMatrix(originalMatrix);
        assertArrayEquals(nulledMatrix, originalMatrix);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRagged() {
        int[][] raggedArray = new int[2][];
        raggedArray[0] = new int[]{1, 2};
        raggedArray[1] = new int[]{3, 4, 0};
        Solution.nullingMatrix(raggedArray);
    }
}
