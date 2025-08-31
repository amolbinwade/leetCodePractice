package com.dsa.leetcodePractice.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 */


public class DuplicateII {

    public static void main(String[] args){
        int[] nums = {0,1,2,3,2,5};
        System.out.println((new DuplicateII())
                .containsNearbyDuplicate(nums, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //use Set to store uniques
        Set<Integer> set = new HashSet<>();
        //use sliding window
        int left=0;
        //increase window till size is k, shrink window if size > k
        for(int right=0; right<nums.length; right++){
            //shrink condition
            if(right-left > k){
                //remove the left element from set
                set.remove(nums[left]);
                left++;
            }
            if(!set.add(nums[right])){
                return true;
            }
        }
        return false;
    }
}
