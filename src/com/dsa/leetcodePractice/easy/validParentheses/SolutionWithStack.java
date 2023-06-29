package com.dsa.leetcodePractice.easy.validParentheses;

/****
 * 
 * @author amol
 * This solution usage Stack to solve the valid parentheseses problem.
 * For every opening parentheses, it pushes the char in stack.
 * For every closing parenthese, it checks the last element in stack and if it is not matching with closing parentheses then it returns false.
 * If it matches, then it pops the stack and make the flag true.
 * After all chars processed in string, if the stack is empty it returns true. If stack is not empty, it means some closing parentheses are still present for which
 * matching closing parentheses were not in String.
 */

public class SolutionWithStack {

	public static void main(String[] args) {		
		
		SolutionWithStack s = new SolutionWithStack();
		System.out.println(s.isValid("([]){"));
		
	}
	
	public boolean isValid(String s) {
		boolean isValid = false;
		MyStack stack = new MyStack();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(isOpeningParentheses(c)){
				stack.push(c);
			} else {
				if(isMatchingParentheses(stack.peek(), c)){
					stack.pop();
					isValid = true;
				} else {
					return false;
				}
			}			
			
		}
		if(!stack.isEmpty()){
			isValid = false;
		}
		
		return isValid;
        
    }
	
	public boolean isOpeningParentheses(char c){
		return c == '(' || c == '[' || c== '{';
	}
	
	public boolean isClosingParentheses(char c){
		return c == ')' || c == ']' || c== '}';
	}
	
	public boolean isMatchingParentheses(char c1, char c2){
		if((c1 == '(' && c2 == ')')
				|| (c1 == '[' && c2 == ']')
				|| (c1 == '{' && c2 == '}')
				){
			return true;
		}
		return false;
		
	}
	
	class MyStack {
		
		char[] arr = new char[5000];
		int head = 0;
		
		public void push(char c){
			arr[head++] = c;		
		}
		
		public char pop(){
			return arr[--head];
			
		}
		
		public char peek(){
			if(head ==0) return 'n';
			return arr[head-1];
		}
		
		public boolean isEmpty(){
			return head==0;
		}
	}
	
	

}
