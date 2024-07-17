package com.dsa.leetcodePractice.arrayandstring;

import java.util.Arrays;

/***
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

public class RotateArray {

    /***
     * Use place-holder array
     * Consider two parts in nums array by identifying index from which the elements will move
     * to start of array after rotation steps. For example if K=3, then last 3 elements will
     * move to first 3 positions in array and earlier first three elements will start from nums[3]
     * index position.
     * part-1 is elements from index. Copy those to start of placeholder array
     * part-2 is elements in nums from start till index-1. Copy those in placeholder array.
     * Copy placeholder array elements to nums
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

         // if array rotated by num.length steps then it will be same array as original
        //  so if k is greater than nums.length then we can only rotate array by k-nums.legth steps
        while(k > nums.length)
            k = k-nums.length;

        //index from where we need to move elements to start of array
        int part1Index = nums.length-k;
        int part2Index = 0;
        int[] tempArray = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(part1Index<nums.length){
                tempArray[i] =  nums[part1Index++];
            } else {
                tempArray[i] = nums[part2Index++];
            }
        }
        for(int i=0; i<nums.length; i++)
            nums[i] = tempArray[i];

    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};

        RotateArray ra = new RotateArray();
        ra.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

    }
}
