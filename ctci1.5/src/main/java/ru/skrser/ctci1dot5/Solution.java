package ru.skrser.ctci1dot5;

/**
 * Created by Sergey Skryabin
 * on 01.01.2017.
 */
public class Solution {
    /**
     * Compresses string, e.g. aaaabcc -> a4b1c2
     * Computational complexity = O(N)
     * Memory consumption = O(N)
     *
     * @param str string to compress
     * @return compressed string or original, if compressed is not smaller
     */
    public static String compress(String str) {
        if (str == null || str.length() <= 2)
            return str;
        StringBuilder sb = new StringBuilder();
        char bufferChar = str.charAt(0);
        int bufferCount = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == bufferChar)
                bufferCount++;
            else {
                sb.append(bufferChar).append(bufferCount);
                bufferChar = str.charAt(i);
                bufferCount = 1;
            }
        }
        sb.append(bufferChar).append(bufferCount);
        String compressedString = sb.toString();
        return str.length() <= compressedString.length() ? str : compressedString;
    }

}
