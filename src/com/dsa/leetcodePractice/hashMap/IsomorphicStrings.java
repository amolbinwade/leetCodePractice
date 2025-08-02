package com.dsa.leetcodePractice.hashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int[] tMap = new int[128];
        int[] sMap = new int[128];

        for(int i=0; i<s.length(); i++){
            char tChar = t.charAt(i);
            char sChar = s.charAt(i);

            sMap[sChar] = tChar;
            tMap[tChar] = sChar;
        }
        for(int i=0; i<s.length(); i++){
            char tChar = t.charAt(i);
            char sChar = s.charAt(i);
            if(tChar != sMap[sChar] || sChar != tMap[tChar])
                return false;
        }
        return true;
    }
}
