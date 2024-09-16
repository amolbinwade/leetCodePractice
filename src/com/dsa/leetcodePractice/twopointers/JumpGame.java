package com.dsa.leetcodePractice.twopointers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {

    /***
     * f(distance, nums[i])
     * f([j-i], nums[i])
     * j = destination, i = prior step, find such i where nums[i] >= [j-i], then j=i
     * start from j=nums.length-1 and i=nums.length-2. stop when i >=0. True if j=0, else false
     * two poiter solution
     * @param nums
     * @return
     */

    public boolean canJump(int[] nums) {

        int j=nums.length-1, i=j-1;
        while(i >= 0 ){
            if((j-i) <= nums[i])
                j=i;
            i--;
        }
        if(j==0)
            return true;
        return false;
    }
}
