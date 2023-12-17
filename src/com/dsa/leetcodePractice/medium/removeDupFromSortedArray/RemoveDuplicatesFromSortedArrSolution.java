package com.dsa.leetcodePractice.medium.removeDupFromSortedArray;

/*
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
 */
public class RemoveDuplicatesFromSortedArrSolution {

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArrSolution solution =
                new RemoveDuplicatesFromSortedArrSolution();
        int[] nums = {1,1,1};
        System.out.println(solution.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int index=0;
        int endIndex=nums.length-1;
        int count=nums.length;

        while(index < endIndex){
            int newIndex = getNewIndex(index, nums);
            System.out.println(newIndex);
            int shiftBy = getShiftBy(nums, index, newIndex);
            count = count-shiftBy;
            newIndex = shiftRight(nums, index, newIndex);
            System.out.println(newIndex);
            System.out.println(" ");
           //for(int i=0; i<nums.length; i++)
             //   System.out.print(nums[i]);
            index = newIndex;
        }
        return count;
    }

    private int getShiftBy(int[] nums, int index, int newIndex) {
        if(newIndex-index <= 2){
            return 0;
        } else {
            return newIndex-index-2;
        }
    }

    private int shiftRight(int[] nums, int index, int newIndex) {
        int shiftBy = newIndex-index-2;
        if(newIndex-index <= 2){
            return newIndex;
        } else {
            int startIndex= newIndex;
            for(int i=index+2; i<nums.length; i++){
                if(i>= nums.length-shiftBy){
                    break;
                }
                nums[i] = nums[startIndex++];
            }
            return newIndex-shiftBy;
        }
    }

    private int getNewIndex(int index, int[] nums) {
        int newIndex = index;
        while(newIndex<nums.length && nums[index]==nums[newIndex])
            newIndex++;
        if(newIndex >= nums.length){
            return index+2;
        }
        return newIndex;
    }
}
