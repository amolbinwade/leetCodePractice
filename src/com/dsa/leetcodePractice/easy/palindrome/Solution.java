package com.dsa.leetcodePractice.easy.palindrome;

public class Solution {
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.isPalindrome(101001));
	}
	
	public boolean isPalindrome(int x) {

        if( x < 10 && x >= 0){
            return true;
        } else if(x < 0){
            return false;
        }else if (x == getReverseOrder(x)){

            return true;
        }
      return false;  
    }

    private int getReverseOrder(int x){
        int[] rArr = new int[10];
        int index = 1;
        rArr = getReverseArr(rArr, index, x);   

        return  getRNum(getLeftMultiplier(rArr[0]), rArr);
        

    }

    private int getRNum(int m, int[] rArr){
        int rNum=0;
        for(int i=1; i<=rArr[0]; i++){
            rNum = rNum + rArr[i]*m;
            m = m/10;
        }
        System.out.println(rNum);
        return rNum;
    }

    private int getLeftMultiplier(int x){
        int m = 1;
        for (int i = 0; i < x-1; i++){
            m = m *10;
        }
        return m;
    }

    private int[] getReverseArr(int[] rArr, int index, int x){
        rArr[0] = rArr[0]+1;
        if(x < 10){
            rArr[index++] = x;
            return rArr;
        } else {
            int left = getLeftPlace(x);            
            int reminder = getReminder(x);
            rArr[index++] = reminder;
            
            return getReverseArr(rArr, index, left);
        }
        
        
    }   
    

    private int getReminder(int x){
        return x%10;
    }

    private int getLeftPlace(int x) {
        int left = x/10;

        return left;
    }

}
