package com.dsa.leetcodePractice.hashMap;

import java.util.HashMap;
import java.util.Map;

/****
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */
public class Anagram {

    public static void main(String[] args){
        Anagram ang = new Anagram();
        System.out.println(ang.isAnagram("KARAM","MARAK"));
        System.out.println(ang.isAnagram("KARAM","MARAKK"));
        System.out.println(ang.isAnagram("ab","b"));
    }

    public boolean isAnagram(String s, String t){
        //validate s and t have same length
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> charMap = new HashMap<>();

        //populate map
        for(Character c : s.toCharArray()){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            } else {
                charMap.put(c, 1);
            }
        }

        //validate anagram
        for(Character c : t.toCharArray()){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)-1);
                if(charMap.get(c)==0){
                    charMap.remove(c);
                }
            } else { // if t char not present in Map, means to anagram
                return false;
            }
        }
        //at the end, validate no element in Map to verify that all chars from S are used in T
        if(charMap.size()>0)
            return false;
        return true;
    }
}
