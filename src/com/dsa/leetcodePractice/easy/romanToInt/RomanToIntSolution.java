package com.dsa.leetcodePractice.easy.romanToInt;

public class RomanToIntSolution {

	public static void main(String[] args) {
		
		RomanToIntSolution s = new RomanToIntSolution();
		System.out.println(s.romanToInt("MCMXCIV"));
		

	}
	
	public int romanToInt(String s) {
		
		Stack stack = new Stack();
		
		for(int i = 0; i<s.length(); i++){
			stack.push(s.charAt(i));
			
		}
		
		int intVal = getIntVal(stack, 0, '-');
		
		return intVal;		
        
    }
	
	public int getIntVal(Stack stack, int leftInt, char prevRoman){
		
		int val = 0;
		int romanToInt = 0;
		
		char roman = stack.pop();
		
		if(roman == '-'){
			return leftInt;
		} else {
		
			romanToInt = getRomanCharToInt(roman);
			
			if((roman == 'I' && (prevRoman == 'V' || prevRoman == 'X'))
					|| (roman == 'X' && (prevRoman == 'L' || prevRoman == 'C'))
					|| (roman == 'C' && (prevRoman == 'D' || prevRoman == 'M'))){
						val = leftInt - romanToInt;
					} else {
						val = leftInt + romanToInt;
					}
			
			
		}
		
		System.out.println("Roman: "+ roman + " Int: "+ romanToInt + " leftVal: "+ leftInt + " val: "+ val);
		return getIntVal(stack, val, roman);
		
	}
	
	public int getRomanCharToInt(char roman) {
		
		if(roman == 'I'){
			return 1;
		} else if(roman == 'V'){
			return 5;
		} else if(roman == 'X'){
			return 10;
		} else if(roman == 'L'){
			return 50;
		} else if(roman == 'C'){
			return 100;
		} else if(roman == 'D'){
			return 500;
		} else if(roman == 'M'){
			return 1000;
		}
		return -1;
	}
	
	
	
	
	class Stack {
		
		char[] roman = new char[15];
		
		int front = 0;
		 
		public void push(char c){
			
			roman[front++] = c;			
		}
		
		public char pop(){
			
			if(front <= 0){
				return '-';
			}
			return roman[--front];
		}
		
	}
	
	

}
