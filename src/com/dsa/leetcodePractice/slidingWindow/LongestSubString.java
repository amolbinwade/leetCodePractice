package com.dsa.leetcodePractice.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/***
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        //use set to maintain occurred char
        Set<Character> set = new HashSet<>();
        //sliding window with two pointers
        int start=0;
        int maxLength=0;
        //iterate by end pointer
        for(int end=0; end<s.length(); end++){
            //if char at end pointer already present then shrink window from start
            //till the end char is not present in set
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }
            //once non-repeating constraint achieved, add end char and measure the length
            set.add(s.charAt(end));
            maxLength=Integer.max(maxLength, end-start+1);
        }
        return maxLength;

    }
}
