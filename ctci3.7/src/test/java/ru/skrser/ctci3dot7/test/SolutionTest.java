package ru.skrser.ctci3dot7.test;

import org.junit.Test;
import ru.skrser.ctci3dot7.Solution;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution shelter = new Solution();

        Solution.Cat a = new Solution.Cat("a");
        Solution.Cat b = new Solution.Cat("b");
        Solution.Dog c = new Solution.Dog("c");
        Solution.Cat d = new Solution.Cat("d");
        Solution.Dog e = new Solution.Dog("e");
        Solution.Dog f = new Solution.Dog("f");
        Solution.Dog g = new Solution.Dog("g");
        Solution.Cat h = new Solution.Cat("h");

        shelter.enqueue(a);
        shelter.enqueue(b);
        shelter.enqueue(c);
        shelter.enqueue(d);
        shelter.enqueue(e);
        shelter.enqueue(f);
        shelter.enqueue(g);
        shelter.enqueue(h);

        assertEquals(a, shelter.dequeAny());
        assertEquals(b, shelter.dequeAny());
        assertEquals(c, shelter.dequeAny());
        assertEquals(e, shelter.dequeDog());
        assertEquals(f, shelter.dequeDog());
        assertEquals(d, shelter.dequeCat());
        assertEquals(h, shelter.dequeCat());
        assertEquals(g, shelter.dequeAny());
    }
}
