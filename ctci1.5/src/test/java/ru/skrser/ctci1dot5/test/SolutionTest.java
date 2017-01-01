package ru.skrser.ctci1dot5.test;

import org.junit.Test;
import ru.skrser.ctci1dot5.Solution;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sergey Skryabin
 * on 01.01.2017.
 */
public class SolutionTest {

    @Test
    public void testPosisive() {
        assertEquals("a4b1c2", Solution.compress("aaaabcc"));
        assertEquals("aaabcc", Solution.compress("aaabcc"));
        assertEquals(null, Solution.compress(null));
        assertEquals("a", Solution.compress("a"));
        assertEquals("aa", Solution.compress("aa"));
        assertEquals("aab", Solution.compress("aab"));
        assertEquals("a3", Solution.compress("aaa"));
        assertEquals("a4b1c2a4b1c2", Solution.compress("aaaabccaaaabcc"));
    }
}
