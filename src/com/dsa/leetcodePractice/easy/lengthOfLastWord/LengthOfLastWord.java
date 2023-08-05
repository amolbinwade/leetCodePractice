package com.dsa.leetcodePractice.easy.lengthOfLastWord;

public class LengthOfLastWord {

    public static void main(String[] args){
        LengthOfLastWord solution = new LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Abra dabra  "));
    }
    public int lengthOfLastWord(String s) {
        int count = 0;
        int loopCounter = 0;
        boolean gotWord = false;
        int maxLength = s.length();
        char space = ' ';

        //loop from index 0 till last char in String
        while(loopCounter < maxLength){

            //if char not space then word starts
            if(s.charAt(loopCounter) != space){

                //if gotWord true means there was earlier word count which needs to be reset
                if(gotWord) {
                    count = 0;
                    //set gotWord to false so that for next chars in this word count won't get reset
                    gotWord = false;
                }
                count++;
            } else {   //if space found then set gotWord flag to true
                gotWord = true;
            }
            loopCounter++;
        }
        return count;
    }

}
