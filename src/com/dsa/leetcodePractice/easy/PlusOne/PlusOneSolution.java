package com.dsa.leetcodePractice.easy.PlusOne;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PlusOneSolution {

    public static void main(String[] args){
        int[] digits = {8,9,9,9};
        PlusOneSolution solution = new PlusOneSolution();
        int[] out = solution.plusOne(digits);
        for(int i=0; i<out.length; i++){
            System.out.print(out[i]);
        }
    }

    public int[] plusOne(int[] digits) {
        //initiate output array.
        int[] outDigits = getOutDigitsArray(digits);

        int reminder = 1; //initialize reminder to 1 to increment by 1 first time
        int counter = digits.length-1; //set counter to loop on digits array
        //loop on output digits array in reverse order
        for(int i=outDigits.length-1; i>=0; i--){
            outDigits[i] = getRightDigit((counter>=0?digits[counter]:0) + reminder);
            reminder = ((counter>=0?digits[counter]:0)+reminder)/10;
            counter--;

        }
        return outDigits;
    }

    private int getRightDigit(int i) {
        return i%10;
    }

    private static int[] getOutDigitsArray(int[] digits) {
        int[] outDigits = null;
        boolean isExtraDigit = true;

        //if all digits are 9 then 1 extra space needed in array after incrementing by 1
        for(int i=0; i<digits.length; i++){
            if(digits[i] != 9)
                isExtraDigit = false;
        }
        //initialize array based on if extra digit needed after increment
        if(isExtraDigit)
           outDigits = new int[digits.length+1];
        else
           outDigits = new int[digits.length];
        return outDigits;
    }


}
