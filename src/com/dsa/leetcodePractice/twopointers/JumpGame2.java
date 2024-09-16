package com.dsa.leetcodePractice.twopointers;


import java.util.Arrays;

/***
 * Array, second largest number
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int[] arr = {2,1};
        System.out.println(JumpGame2.jump(arr));

    }

    /***
     * Consider BFS type solution.
     * Example : [2,3,1,1,4]
     * 2
     * 3 1
     * 1 1 3
     * step1- if length is 0 or 1, return 0
     * step2- define currentRange as nums[0], set jumpsCount to 1 as at least 1 jump needed
     * step3- loop by incrementing 1 step at a time
     * step4- if currentRange reaching last element then return jumpsCount
     * step4- loop from i to currentRange to find maxRange at that level.
     * step5- on end of loop2, set currentRange to maxRange and increment jumpsCount as next level needed
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if(nums.length<2)
            return 0;

        int i=0; //to incrementally step ahead
        int maxRange = 0; // to store the current maximum range
        int currentRange= nums[0];
        int jumpsCount = 1;

        while(i<=nums.length-1){
            if(currentRange >= nums.length-1)
                return jumpsCount;
            while(i<= currentRange){
                maxRange = Math.max(nums[i]+i, maxRange);
                i++;
            }
            currentRange = maxRange;
            jumpsCount++;
        }
        return 0;
    }
}
