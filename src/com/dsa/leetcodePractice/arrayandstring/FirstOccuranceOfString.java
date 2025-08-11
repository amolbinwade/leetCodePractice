package com.dsa.leetcodePractice.arrayandstring;


/****
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class FirstOccuranceOfString {

    public static void main(String[] args) {
        FirstOccuranceOfString solution = new FirstOccuranceOfString();
        System.out.println(solution.strStr("s","s"));
    }

    public int strStrV2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        //loop
            //find first char
                //loop to compare remaining chars
                    //if all chars match then return first char index
                    //else break and go back to finding further first char

         for(int firstIndex=0; firstIndex<=haystack.length()-1; firstIndex++){
            char firstChar = needle.charAt(0);
            while(firstIndex<haystack.length()-1 && firstChar!=haystack.charAt(firstIndex)){
                firstIndex++;
            }
            //found first char index. Now check remaining chars
            for(int j=firstIndex,k=0; k<=needle.length()-1 && j<=haystack.length()-1; j++,k++){
                if(needle.charAt(k)!=haystack.charAt(j))
                    break;
                if(k==needle.length()-1)
                    return firstIndex;
            }
        }
        return -1;
    }
}
