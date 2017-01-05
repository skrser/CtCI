package ru.skrser.ctci2dot5;

public class Solution {

    /**
     * Sums two numbers, that are represented in linked lists - one digit per node in reverse order.
     * Computation complexity = O(N)
     * Memory consumption = O(N), for result list
     *
     * @param head1 reference to first number list's head node
     * @param head2 reference to second number list's head node
     * @return reference to result number list's head node
     */
    public static Node sumReverse(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            throw new NullPointerException("Arguments should be not null!");

        Node resultHead = new Node();
        Node resultCursor = resultHead;

        Node cursor1 = head1;
        Node cursor2 = head2;

        byte shift = 0;
        byte digit1, digit2, resultDigit;

        while (cursor1 != null || cursor2 != null) {
            digit1 = getDigit(cursor1);
            digit2 = getDigit(cursor2);
            resultDigit = (byte) (digit1 + digit2 + shift);
            shift = (byte) (resultDigit / 10);
            resultCursor.data = (byte) (resultDigit % 10);
            if (cursor1 != null)
                cursor1 = cursor1.next;
            if (cursor2 != null)
                cursor2 = cursor2.next;
            if (cursor1 != null || cursor2 != null || shift != 0) {
                resultCursor.next = new Node();
                resultCursor = resultCursor.next;
            }
        }
        if (shift != 0)
            resultCursor.data = shift;

        return resultHead;
    }

    private static byte getDigit(Node cursor) {
        if (cursor != null) {
            byte digit = cursor.data;
            if (digit < 0 || digit > 9)
                throw new IllegalArgumentException("Data contains invalid digit:" + digit);
            return digit;
        } else
            return 0;
    }

    public static Node reverseListDirection(Node head) {
        Node newHead = null, previousNode = null;
        Node cursor = head;
        while (cursor != null) {
            newHead = new Node();
            newHead.data = cursor.data;
            newHead.next = previousNode;
            previousNode = newHead;
            cursor = cursor.next;
        }
        return newHead;
    }

    /**
     * Sums two numbers, that are represented in linked lists - one digit per node in forward order.
     * Computation complexity = O(N)
     * Memory consumption = O(N)
     *
     * @param head1 reference to first number list's head node
     * @param head2 reference to second number list's head node
     * @return reference to result number list's head node
     */
    public static Node sumForward(Node head1, Node head2) {
        return reverseListDirection(sumReverse(reverseListDirection(head1), reverseListDirection(head2)));
    }

}
