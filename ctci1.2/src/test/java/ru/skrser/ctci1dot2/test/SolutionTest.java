package ru.skrser.ctci1dot2.test;

import org.junit.Test;
import ru.skrser.ctci1dot2.Solution;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sergey Skryabin
 * on 06.11.2016.
 */
public class SolutionTest {

    @Test
    public void testPositive() {
        testArrays(new Character[]{'a', null}, new Character[]{'a', null});
        testArrays(new Character[]{'a', 'b', null}, new Character[]{'b', 'a', null});
        testArrays(new Character[]{'a', 'a', null}, new Character[]{'a', 'a', null});
        testArrays(new Character[]{'a', 'b', 'c', null}, new Character[]{'c', 'b', 'a', null});
        testArrays(new Character[]{'a', 'b', 'c', null, 'd'}, new Character[]{'c', 'b', 'a', null, 'd'});
        testArrays(new Character[]{'a', 'b', 'c', 'd', null}, new Character[]{'d', 'c', 'b', 'a', null});
        testArrays(new Character[]{'a', 'b', 'c', 'd', null, 'e', 'f'}, new Character[]{'d', 'c', 'b', 'a', null, 'e', 'f'});
        testArrays(new Character[]{'a', 'b', 'c', null, 'd', null, 'e', 'f'}, new Character[]{'c', 'b', 'a', null, 'd', null, 'e', 'f'});
    }

    @Test
    public void testDoubleReverse() {
        Character[] str = new Character[]{'a', 'b', 'c', 'd', null, 'e'};
        Character[] strRev = str.clone();
        Solution.reverse(str);
        Solution.reverse(str);
        assertArrayEquals(strRev, str);
    }

    private void testArrays(Character[] str, Character[] strRev) {
        Solution.reverse(str);
        assertArrayEquals(strRev, str);
    }

    @Test
    public void testExtreme() {
        testArrays(new Character[]{null}, new Character[]{null});
    }

    @Test(expected = NullPointerException.class)
    public void testWrongData() {
        Solution.reverse(null);
    }

}
