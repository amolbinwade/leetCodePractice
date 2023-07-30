package com.dsa.leetcodePractice.easy.removeDuplicates;

public class SimpleSolution {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(i ==0)
                nums[k++] = nums[i];
            else {
                if(nums[i] == nums[k-1]){
                    continue;
                } else {
                    nums[k++] = nums[i];
                }
            }
        }
        return k;
    }
}
