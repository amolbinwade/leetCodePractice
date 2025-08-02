package com.dsa.leetcodePractice.hashMap;

import java.util.HashMap;
import java.util.Map;

/***
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            /*if(map.get(c) != null){
                map.put(c, map.get(c)+1);
            } else{
                map.put(c, 1);
            }*/
            //Shorter alternate code for above commented block.
            //if c not present then add with value 1, if present adds 1 to existing value
            map.merge(c, 1, Integer::sum);
        }

        for(char c : ransomNote.toCharArray()){
            if(map.get(c) == null){
                return false;
            } else{
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }
        }
        return true;
    }
}
