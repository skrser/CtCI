package ru.skrser.ctci1dot1.test;

import org.junit.Test;
import ru.skrser.ctci1dot1.Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sergey Skryabin
 * on 05.11.2016.
 */
public class SolutionTest {

    @Test
    public void testPositive() {
        assertTrue(Solution.isUniqueChars("abc123"));
        assertTrue(Solution.isUniqueCharsNoAdditionalDataStructures("abc123"));
    }

    @Test
    public void testNegative() {
        assertFalse(Solution.isUniqueChars("abc12a13"));
        assertFalse(Solution.isUniqueCharsNoAdditionalDataStructures("abc12a13"));
    }

    @Test(expected = NullPointerException.class)
    public void testWrongData() {
        Solution.isUniqueChars(null);
    }

    @Test(expected = NullPointerException.class)
    public void testWrongData2ndMethod() {
        Solution.isUniqueCharsNoAdditionalDataStructures(null);
    }

}
