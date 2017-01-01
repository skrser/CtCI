package ru.skrser.ctci1dot4.test;

import org.junit.Test;
import ru.skrser.ctci1dot4.Solution;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sergey Skryabin
 * on 01.01.2017.
 */
public class SolutionTest {

    private static String solutionStringWrapper(String str) {
        char[] strArray = str.toCharArray();
        Solution.replaceSpaces(strArray);
        return new String(strArray);
    }

    @Test
    public void testPositive() {
        assertEquals("abc%20de%20f", solutionStringWrapper("abc de f    "));
        assertEquals("%20abc%20de%20%20f", solutionStringWrapper(" abc de  f        "));
        assertEquals("123", solutionStringWrapper("123"));
        assertEquals("", solutionStringWrapper(""));
    }

    @Test
    public void testOnlySpaces() {
        assertEquals(" ", solutionStringWrapper(" "));
        assertEquals("     ", solutionStringWrapper("     "));
    }

    @Test(expected = NullPointerException.class)
    public void testNullData() {
        Solution.replaceSpaces(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testFailedPrecondition() {
        Solution.replaceSpaces(" 1".toCharArray());
    }

}
