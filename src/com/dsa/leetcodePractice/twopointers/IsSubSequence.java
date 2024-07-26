package com.dsa.leetcodePractice.twopointers;

/***
 *     Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *     A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *     Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters
 */

public class IsSubSequence {

    /***
     * Simple two pointer solution.
     * create two char arrays from s and t.
     * Need comparison between two arrays. So one pointer for each array.
     * Both arrays can start from 0th index.
     * Increase s pointer only when match is found in the t array.
     * Increase t pointer in each iteration.
     * Return true when s pointer reaches end of array.
     * LEARNING: to compare two arrays, we don't need nested loops. We can use two pointers.     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequencePresent(String s, String t) {
        if (s.length() == 0)
            return true;

        int sp = 0, tp = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        while (sp < sChars.length && tp < tChars.length) {
            if (sChars[sp] == tChars[tp])
                sp++;
            tp++;
            if (sp == sChars.length)
                return true;
        }
        return false;
    }

}
