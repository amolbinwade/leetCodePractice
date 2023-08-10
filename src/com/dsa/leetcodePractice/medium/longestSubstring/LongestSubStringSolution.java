package com.dsa.leetcodePractice.medium.longestSubstring;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Amol Binwade
 * We will use sliding window template to solve this problem.
 * Loop through the string chars
 * run internal loop till char doesn't repeat and count length
 */
public class LongestSubStringSolution {

    public static void main(String args[]){
        LongestSubStringSolution solution = new LongestSubStringSolution();
        int i = solution.lengthOfLongestSubstring("abxyzfadc");
        System.out.println(i);
    }


    public int lengthOfLongestSubstring(String s) {

        //if empty string then return 0
        if(s.length() == 0)
            return 0;
        //variable to keep max length of non-repeating substring
        int max = 0;

        //loop on the chars in string : window frame
        for(int i=0; i<s.length(); i++){
            int counter = i;
            int maxCount=0;

            //set to keep occured chars
            Set<Character> set = new TreeSet<>();

            //sliding window: increment count till char doesn't repeat
            while(counter<s.length() && !set.contains(s.charAt(counter))){
                set.add(s.charAt(counter++));
                maxCount++;
            }

            //if new count is greater than previous count then set new count as max length
            if(maxCount > max){
                max = maxCount;
            }
        }
        return max;
    }
}
