package com.dsa.leetcodePractice.easy.lengthOfLastWord;

/***
 * In this solution, we start loop in reverse order from last char in string.
 * So that we will directly find the last word, instead of finding each word from start and determining last word.
 */
public class LengthOfLastWordOptimized {

    public static void main(String[] args){
        LengthOfLastWordOptimized solution = new LengthOfLastWordOptimized();
        System.out.println(solution.lengthOfLastWord("Abra dabra"));
    }
    public int lengthOfLastWord(String s) {

        int loopCounter = s.length()-1;
        int count = 0;

        //set loop from last char
        while(loopCounter >=0){
            //directly find the last word
            if(s.charAt(loopCounter--) != ' '){
                count++;
            } else {
                if(count > 0){ //if space found and count not zero means length or last word found. Return it.
                    return count;
                }
            }

        }

       return 0;
    }

}