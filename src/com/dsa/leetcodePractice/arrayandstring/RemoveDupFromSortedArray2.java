package com.dsa.leetcodePractice.arrayandstring;

/***
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */


public class RemoveDupFromSortedArray2 {

    /***
     * Method with two loops.
     * Loop-1 array iteration from 0th index
     * Skip for i=0,1
     * if ith element is equals to i-1 and i-2 elements in array then start loop-2
     * loop-2 : shift all left elements by 1 place to left
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int endIndex = nums.length;
        while(i < endIndex){
            if(i==0){
                i++;
            } else if(i==1){
                i++;
            } else if(nums[i] == nums[i-1] && nums[i]==nums[i-2]){
                for(int j=i; j<endIndex-1; j++){
                    nums[j] = nums[j+1];

                }
                endIndex--;
            } else {
                i++;
            }
        }
        return i;
    }

    /***
     * Optimized solution with O(n) complexity and 1 loop only
     * two pointer solution
     * one pointer increments consistently from start to end
     * other pointer stops at place where duplicate is occurring.
     * If not duplicate then copy element at first point to element at second pointer.
     *
     * LEARNING: Even if we need to check all elements in array to find duplicates, the elements
     * shifting doesn't need second loop. We can avoid that by having second points and condition when
     * second pointer shall move.
     *
     * @param nums
     * @return
     */

    public int removeDuplicatesOptimized(int[] nums){
        int i=0;
        for(int n:nums)
            if(i<2 || n!=nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,1,2,3,3};

        RemoveDupFromSortedArray2 obj = new RemoveDupFromSortedArray2();
        int output = obj.removeDuplicatesOptimized(nums);

        for(int i=0; i<output; i++){
            System.out.println(nums[i]);
        }

    }

}
