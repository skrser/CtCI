package ru.skrser.ctci2dot5.test;

import org.junit.Test;
import ru.skrser.ctci2dot5.Node;
import ru.skrser.ctci2dot5.Solution;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private long getNumber(Node head) {
        long result = 0L;
        Node cursor = head;
        int power = 0;
        while (cursor != null) {
            result += (long) (cursor.data * Math.pow(10, power++));
            cursor = cursor.next;
        }
        return result;
    }

    private Node getList(long number) {
        Node head = new Node();
        Node cursor = head;

        while (number > 0) {
            byte digit = (byte) (number % 10);
            number /= 10;
            cursor.data = digit;
            if (number > 0) {
                cursor.next = new Node();
                cursor = cursor.next;
            }
        }
        return head;
    }

    @Test
    public void testSumReverse() {
        Node number1 = getList(545);
        Node number2 = getList(458);
        Node result = Solution.sumReverse(number1, number2);
        assertEquals(1003, getNumber(result));

        number1 = getList(0);
        number2 = getList(11);
        result = Solution.sumReverse(number1, number2);
        assertEquals(11, getNumber(result));

        for (int i = 0; i < 50; i++) {
            long number1Long = (long) (Long.MAX_VALUE * 0.5 * Math.random());
            long number2Long = (long) (Long.MAX_VALUE * 0.5 * Math.random());
            number1 = getList(number1Long);
            number2 = getList(number2Long);
            result = Solution.sumReverse(number1, number2);
            assertEquals(number1Long + number2Long, getNumber(result));
        }
    }

    @Test
    public void testSumForward() {
        Node number1 = Solution.reverseListDirection(getList(545));
        Node number2 = Solution.reverseListDirection(getList(457));
        Node result = Solution.sumForward(number1, number2);
        assertEquals(1002, getNumber(Solution.reverseListDirection(result)));
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Solution.sumReverse(null, new Node());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        Solution.sumReverse(new Node((byte) -4), new Node());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNondigits() {
        Solution.sumReverse(new Node(), new Node((byte) 15));
    }

}
