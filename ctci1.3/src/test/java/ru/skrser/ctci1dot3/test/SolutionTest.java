package ru.skrser.ctci1dot3.test;

import org.junit.Test;
import ru.skrser.ctci1dot3.Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sergey Skryabin
 * on 06.11.2016.
 */
public class SolutionTest {

    @Test
    public void testPositive() {
        assertTrue(Solution.isPermutation("", ""));
        assertTrue(Solution.isPermutation("a", "a"));
        assertTrue(Solution.isPermutation("abc", "abc"));
        assertTrue(Solution.isPermutation("abc123", "12ab3c"));
        assertTrue(Solution.isPermutation("abbccc123", "1b2abcc3c"));
    }

    @Test
    public void testNegative() {
        assertFalse(Solution.isPermutation("a", "b"));
        assertFalse(Solution.isPermutation("a", "aa"));
        assertFalse(Solution.isPermutation("ab", "aa"));
        assertFalse(Solution.isPermutation("abb", "aab"));
    }

    @Test(expected = NullPointerException.class)
    public void testWrongData1() {
        Solution.isPermutation(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testWrongData2() {
        Solution.isPermutation("abc", null);
    }

    @Test(expected = NullPointerException.class)
    public void testWrongData3() {
        Solution.isPermutation(null, "abc");
    }

}
