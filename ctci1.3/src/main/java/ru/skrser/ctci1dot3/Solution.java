package ru.skrser.ctci1dot3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey Skryabin
 * on 06.11.2016.
 */
public class Solution {

    /**
     * Checks if one string is permutation of another
     * Computational complexity = O(n)
     * Memory consumption = O(n)
     *
     * @param s1 first string
     * @param s2 second string
     * @return true if permutation
     */
    public static boolean isPermutation(String s1, String s2) {
        if (s1 == null)
            throw new NullPointerException("s1 is null");
        if (s2 == null)
            throw new NullPointerException("s2 is null");

        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> s1Contents = disassemble(s1);
        Map<Character, Integer> s2Contents = disassemble(s2);
        return s1Contents.equals(s2Contents);
    }

    private static Map<Character, Integer> disassemble(String str) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (Character c : str.toCharArray()) {
            if (charMap.containsKey(c))
                charMap.put(c, charMap.get(c) + 1);
            else
                charMap.put(c, 1);
        }

        return charMap;
    }
}
