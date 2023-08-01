package com.dsa.leetcodePractice.easy.searchInsertPosition;

public class SearchInsertPosition {

    public static void main(String[] args){

        int[] nums = {1,3,5,6};
        SearchInsertPosition solution = new SearchInsertPosition();
        int target = solution.searchInsert(nums, 2);
        System.out.println(target);

    }

    public int searchInsert(int[] nums, int target) {
        return searchByDivideAndConqr(nums, 0, nums.length-1, target);
    }

    private int searchByDivideAndConqr(int[] nums, int startIndex, int endIndex, int target){
        if(endIndex-startIndex <= 1){
            if(target == nums[endIndex]){
                return endIndex;
            } else if (target > nums[endIndex]) {
                return endIndex+1;
            }  else if (target > nums[startIndex]) {
                return startIndex+1;
            } else {
                return startIndex;
            }
        } else {
            int midIndex = getMidIndex(startIndex, endIndex);

            //check if midIndex has target
            if(nums[midIndex] == target){
                return midIndex;
            } else {
                if(nums[midIndex] > target){
                    return searchByDivideAndConqr(nums, startIndex, midIndex, target);
                } else {
                    return searchByDivideAndConqr(nums, midIndex, endIndex, target);
                }
            }
        }
    }

    private int getMidIndex(int startIndex, int endIndex) {
        return ((endIndex-startIndex)/2)+startIndex;
    }
}
