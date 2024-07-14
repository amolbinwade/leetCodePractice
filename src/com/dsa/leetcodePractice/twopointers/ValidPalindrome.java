package com.dsa.leetcodePractice.twopointers;

/***
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */

public class ValidPalindrome {

    /***
     * Simple solution with two pointers:
     * 1. Remove all non-alphaNumeric chars from string
     * 2. Convert string to lower case
     * 3. one pointer from head and second pointer from tail and compare chars. If not matching then not valid palindrome
     * 4. Break loop when pointers meet
     * 5. Return true by default if no non matching chars found
     * @param s
     * @return
     */

    public boolean isPalindrome(String s) {
        //use regex to remove space and non-alphaNumeric characters
        s = s.replaceAll("[^a-zA-Z0-9]","");

        //conver to lowercase
        s = s.toLowerCase();

        //initiate two pointers
        int headPointer=0, tailPointer=s.length()-1;

        //if char with headPointer not matching with char at tailPointer then not palindrome
        //break loop when two pointers cross/meet each other
        while(headPointer < tailPointer)
            if(s.charAt(headPointer++) == s.charAt(tailPointer--))
                continue;
            else
                return false;
        return true;
    }

    /***
     * In first approached we pre-processed complete string to remove non-alphanumeric characters and to conver to lower case.
     * These steps are overhead if we find the string is not palindrome in early stage in the loop.
     * So we can shift transformation to later stage during comparison to save time for invalid inputs.
     *
     * LEARNING: Shift transformation to later stage during comparison to save time for invalid inputs, instead of doing transformation as pre-processing.
     * @param s
     * @return
     */
    public boolean isPalindromeOptimized(String s){
        int headPointer=0, tailPointer=s.length()-1;

        while(headPointer < tailPointer) {
            if (!Character.isLetterOrDigit(s.charAt(headPointer))) {
                headPointer++;
            } else if (!Character.isLetterOrDigit(s.charAt(tailPointer))) {
                tailPointer--;
            } else if (Character.toLowerCase(s.charAt(headPointer++)) != Character.toLowerCase(s.charAt(tailPointer--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";

        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindromeOptimized(s));


    }
}
