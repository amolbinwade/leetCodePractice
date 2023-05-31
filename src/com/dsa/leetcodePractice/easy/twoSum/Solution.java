package com.dsa.leetcodePractice.easy.twoSum;

public class Solution {
	
	public int[] twoSum(int[] nums, int target) {
        boolean found = false;
        int[] output = new int[2];
        for(int i =0; i < nums.length-1; i++){
            for(int j = 1; j < nums.length; j ++){
                if(i != j){
                    if((nums[i] + nums[j]) == target){
                      found = true;
                        output[0] = i;
                        output[1] = j;
                        break; 
                    }
                }
            }
            if(found){
                break;
            }
        }
        return output;
        
    }

}
