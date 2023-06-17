package com.dsa.leetcodePractice.easy.romanToInt;

public class RomanToIntWithoutRecursionSolution {

	public static void main(String[] args) {

		RomanToIntWithoutRecursionSolution s = new RomanToIntWithoutRecursionSolution();
		System.out.println(s.romanToInt("MCMXCIV"));

	}

	public int romanToInt(String s) {

		int leftInt = 0;
		char prevRoman = '-';
		int val = 0;

		for (int i = s.length() - 1; i >= 0; i--) {

			char roman = s.charAt(i);
			int romanToInt = getRomanCharToInt(roman);
			
			if((roman == 'I' && (prevRoman == 'V' || prevRoman == 'X'))
					|| (roman == 'X' && (prevRoman == 'L' || prevRoman == 'C'))
					|| (roman == 'C' && (prevRoman == 'D' || prevRoman == 'M'))){
						val = leftInt - romanToInt;
					} else {
						val = leftInt + romanToInt;
					}
			
			leftInt = val;
			prevRoman = roman;
			
			
		}
		
		return val;

	}

	public int getRomanCharToInt(char roman) {

		if (roman == 'I') {
			return 1;
		} else if (roman == 'V') {
			return 5;
		} else if (roman == 'X') {
			return 10;
		} else if (roman == 'L') {
			return 50;
		} else if (roman == 'C') {
			return 100;
		} else if (roman == 'D') {
			return 500;
		} else if (roman == 'M') {
			return 1000;
		}
		return -1;
	}

}
