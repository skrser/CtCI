package ru.skrser.ctci2dot7;

public class Solution {

    /**
     * Finds if linked list is palindrome
     * Computation complexity = O(N)
     * Memory consumption = O(N)
     *
     * @param head reference to list's head node
     * @return true if list is palindrome
     */
    public static boolean isPalindrome(Node head) {
        Node cursor = head;
        Node reverseCursor = getReverseList(head);

        // or we could go to list.length/2
        while (cursor != null) {
            if (cursor.data != reverseCursor.data)
                return false;
            cursor = cursor.next;
            reverseCursor = reverseCursor.next;
        }
        return true;
    }

    private static Node getReverseList(Node head) {
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

}
