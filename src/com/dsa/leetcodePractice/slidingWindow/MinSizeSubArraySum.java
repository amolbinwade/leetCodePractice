package com.dsa.leetcodePractice.slidingWindow;


/***
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class MinSizeSubArraySum {

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        MinSizeSubArraySum minSizeSubArraySum = new MinSizeSubArraySum();
        System.out.println(minSizeSubArraySum.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        // initiate an array to hold the sub-array with sum elements
        int[] subArray = new int[nums.length];
        int sum = nums[0];
        int i=0, j=1;
        // loop nums and keep adding elements to subArray till sum <= target
        if(sum >= target)
            return 1;
        while(sum < target){
            sum += nums[j++];
            
            if(sum >= target){
                return subArray.length;
            }
        }
        return 0;
    }
}
