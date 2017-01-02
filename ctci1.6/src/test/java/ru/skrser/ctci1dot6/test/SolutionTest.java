package ru.skrser.ctci1dot6.test;

import org.junit.Test;
import ru.skrser.ctci1dot6.Solution;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sergey Skryabin
 * on 01.01.2017.
 */
public class SolutionTest {

    @Test
    public void testNull() {
        Solution.rotate(null);
    }

    @Test
    public void test1x1() {
        byte[][][] image = {{{100, 127, 1, -128}}};
        final byte[][][] rotatedImage = {{{100, 127, 1, -128}}};
        Solution.rotate(image);
        assertArrayEquals(rotatedImage, image);
    }

    @Test
    public void test2x2() {
        byte[][][] image = {{{ 1,  2,  3,  4}, {11, 12, 13, 14}},
                            {{21, 22, 23, 24}, {31, 32, 33, 34}}};
        final byte[][][] rotatedImage = {{{21, 22, 23, 24}, { 1,  2,  3,  4}},
                                        { {31, 32, 33, 34}, {11, 12, 13, 14}}};
        Solution.rotate(image);
        assertArrayEquals(rotatedImage, image);
    }

    @Test
    public void test3x3() {
        byte[][][] image = {{{ 1,  2,  3,  4}, {11, 12, 13, 14}, {21, 22, 23, 24}},
                            {{31, 32, 33, 34}, {41, 42, 43, 44}, {51, 52, 53, 54}},
                            {{61, 62, 63, 64}, {71, 72, 73, 74}, {81, 82, 83, 84}}};
        final byte[][][] rotatedImage = {{{61, 62, 63, 64}, {31, 32, 33, 34}, { 1,  2,  3,  4}},
                                         {{71, 72, 73, 74}, {41, 42, 43, 44}, {11, 12, 13, 14}},
                                         {{81, 82, 83, 84}, {51, 52, 53, 54}, {21, 22, 23, 24}}};
        Solution.rotate(image);
        assertArrayEquals(rotatedImage, image);
    }
}
