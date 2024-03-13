package com.dsa.leetcodePractice.easy.removeDuplicates;

public class SimpleSolution {

    /*
        Use two pointers i and j.
        j will point to the place where unique element need to be placed.
        j will have 1 as initial value as 0th element will always be unique.
        i will loop from first to last index
     */
    public int removeDuplicates(int[] nums) {
        int j=1;
        for(int i=1; i < nums.length; i++){
            // if ith value is different than value at i-1, then unique element found
            if(nums[i]!=nums[i-1]){
                nums[j++] = nums[i];
            }
        }
        return j;

    }
}
