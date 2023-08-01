package com.dsa.leetcodePractice.easy.firstOccuranceOfSubString;

public class SolutionFirstOccurrenceOfSubstring {

    public static void main(String[] args) {
        SolutionFirstOccurrenceOfSubstring solution = new SolutionFirstOccurrenceOfSubstring();
        System.out.println(solution.strStr("mississippi","issip"));
    }

    public int strStr(String haystack, String needle) {
        int index = -1;
        int needleIndex = 0;

        //get length of haystack and needle
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        //get first char of needle
        char firstChar = needle.charAt(0);

        //use the sliding window logic
        //loop for each char in haystack
        for(int i=0; i<=(haystackLength-needleLength); i++){

            //fast forward reference of haystack to char matching with first char of needle
            while(i< haystackLength && haystack.charAt(i) != firstChar)
                i++;

            //if i reaches beyond last letter in haystack, then needle not found. Break.
            if(i == haystackLength)
                break;

            //when first letter of needle found then set index to i
            index = i;

            //sliding window: loop till i+needleLength
            for(int j=0; j < needleLength && (i+j)<haystackLength && (haystack.charAt(i+j) == needle.charAt(j)); j++, needleIndex++);

            //if needleIndex reaches till needle length means all char are found. Then break.
            if(needleIndex == needle.length()){
                break;
            } else {
                //if needleIndex doesn't reach till needle length means all char are not found. Then reset needleIndex and index.
                needleIndex = 0;
                index = -1;
            }
        }
        return index;

    }
}
