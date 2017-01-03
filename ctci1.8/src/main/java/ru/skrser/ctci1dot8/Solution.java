package ru.skrser.ctci1dot8;

public class Solution {

    /**
     * Checks if one string is result of rotation of another (e.g. "result" and "sultre"),
     * using only one execution of given method "isSubstring".
     * Method is symmetric, i.e. isRotation(s1, s2) == isRotation(s2, s1)
     * Computational complexity = O(n^2)
     * Memory consumption = O(n)
     *
     * @param s1 first string
     * @param s2 second string
     * @return true if s2 is result of rotation of s1
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1 == null)
            return s2 == null;
        else if (s2 == null)
            return false;
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        int delimiter = findDelimiterPosition(s1, s2);
        return delimiter != -1 && isSubstring(s1.substring(delimiter, s1.length()), s2.substring(0, s2.length() - delimiter));
    }

    private static boolean isSubstring(String string, String substring) {
        return string.contains(substring);
    }

    private static int findDelimiterPosition(String s1, String s2) {
        int i = 0;
        int delta = 0;
        while (i + delta < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i + delta))
                i++;
            else {
                delta++;
                i = 0;
            }
        }
        if (delta != s2.length())
            return i;
        else
            return -1;
    }

    public static boolean isRotationMoreElegant(String s1, String s2) {
        if (s1 == null)
            return s2 == null;
        else if (s2 == null)
            return false;
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }

}
