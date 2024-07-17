package com.dsa.leetcodePractice.arrayandstring;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordsInNote {

    public static void main(String[] args){

        String notes = "datc";
        String[] words = {"catt", "dog","at"};
        System.out.println(getWordFromNote(words, notes));

    }

    public static String getWordFromNote(String[] words, String note){
        for(String word : words){
            if(isWordPresentInNote(word, note))
                return word;
        }
        return "-";
    }

    public static boolean isWordPresentInNote(String word, String note){
        char[] wordChars = word.toCharArray();
        List<Character> list;
        list = note.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        for(char c : wordChars){
            if(!list.remove((Character)c)){
                return false;
            }
        }
        return true;
    }
}
