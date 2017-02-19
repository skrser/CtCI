package ru.skrser.ctci1dot4;

/**
 * Created by Sergey Skryabin
 * on 01.01.2017.
 */
public class Solution {

    /**
     * Replaces all spaces in given string (char array) to %20
     * Precondition: array has sufficient space (at the end) for replacement
     * Computational complexity = O(N)
     * Memory consumption = O(1)
     *
     * @param str mutable string (char array) with spaces
     */
    public static void replaceSpaces(char[] str) {
        int writeIndex = str.length - 1;
        for (int cursor = getLastNonSpaceCharIndex(str); cursor >= 0; cursor--) {
            if (str[cursor] != ' ') {
                str[writeIndex--] = str[cursor];
            } else {
                str[writeIndex--] = '0';
                str[writeIndex--] = '2';
                str[writeIndex--] = '%';
            }
        }
    }

    private static int getLastNonSpaceCharIndex(char[] str) {
        for (int cursor = str.length - 1; cursor >= 0; cursor--)
            if (str[cursor] != ' ')
                return cursor;

        return -1;
    }

}
