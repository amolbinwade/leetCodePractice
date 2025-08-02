package com.dsa.leetcodePractice.hashMap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    //check if length of pattern and words matches
    //map char to word and word to char
    //check if each char and word has consistent mapping, if not then return false

    public boolean isWordPatternCorrect(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        int i = 0;

        if(words.length != chars.length){
            return false;
        }
        for(char c: chars){

            if(map.containsKey(c) || map2.containsKey(words[i])){
                if(!words[i].equals(map.get(c))
                        || c!=(map2.get(words[i]))){
                    return false;
                }
            } else {
                map.put(c, words[i]);
                map2.put(words[i],c);
            }
            i++;
        }
        return true;

    }
}
