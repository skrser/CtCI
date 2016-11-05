package ru.skrser.ctci1dot1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergey Skryabin
 * on 05.11.2016.
 */
public class Solution {

    /**
     * Checks if str contains only unique characters
     * Computational complexity = O(n)
     * Memory consumption = O(n)
     *
     * @param str string to check
     * @return true if str contains only unique characters
     */
    public static boolean isUniqueChars(String str) {
        if (str == null)
            throw new NullPointerException("str is null");

        Set<Character> foundChars = new HashSet<Character>();
        for (Character c : str.toCharArray()) {
            if (foundChars.contains(c))
                return false;
            else
                foundChars.add(c);
        }
        return true;
    }

    /**
     * Checks if str contains only unique characters
     * Computational complexity = O(n^2)
     * Memory consumption = O(1)
     *
     * @param str string to check
     * @return true if str contains only unique characters
     */
    public static boolean isUniqueCharsNoAdditionalDataStructures(String str) {
        if (str == null)
            throw new NullPointerException("str is null");

        for (int i = 0; i < str.length() - 1; i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }

}
