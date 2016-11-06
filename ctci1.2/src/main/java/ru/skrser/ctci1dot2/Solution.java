package ru.skrser.ctci1dot2;

/**
 * Created by Sergey Skryabin
 * on 06.11.2016.
 */
public class Solution {

    /**
     * Reverse null terminated array
     * Computational complexity = O(n)
     * Memory consumption = O(1)
     *
     * @param str char array to be reverted
     */
    public static void reverse(Character[] str) {
        if (str == null)
            throw new NullPointerException("str is null");

        int end = 0;
        for (Character c : str) {
            if (c != null)
                end++;
            else
                break;
        }

        for (int i = 0; i < end / 2; i++)
            swap(str, i, end - 1 - i);
    }

    private static void swap(Object[] array, int firstIndex, int secondIndex) {
        Object tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

}
