package ru.skrser.ctci4dot3;

import java.util.Arrays;

public class Solution {

    /**
     * Converts sorted array to binary search tree
     * Computation complexity = O(N)
     * Memory consumption = O(log N) (for stack)
     * plus additional memory for Arrays.copyOfRange - could by reduced by implementing some kind of subArray method
     *
     * @param array source array
     * @return reference to target tree root
     */
    public static Node convertToTree(int[] array) {
        if (array.length == 0)
            return null;
        Node root = new Node();
        int middle = array.length / 2;
        root.value = array[middle];
        root.left = convertToTree(Arrays.copyOfRange(array, 0, middle));
        root.right = convertToTree(Arrays.copyOfRange(array, middle + 1, array.length));

        return root;
    }

}
