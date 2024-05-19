package com.dsa.leetcodePractice.medium.containerWithMostWater;

/*******
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 * Solution Approach:
 * Two Pointers:
 * Pointer i starts from start of array and j from end of array.
 * Calculate volume and if > than maxVolume then replace maxVolume.
 * Here, tricky part is how to decide which pointer to move on what condition.
 * This can be decided based on function(i,j) which is min(i,j) and keep greater pointer at same place.
 *
 */

public class ContainerWIthMostWaterTwoPointers {
    public int maxArea(int[] height) {

        //water volume = min(p, q) * distance(p, q)
        int maxVolume=0;
        int i=0;
        int j=height.length-1;
        while(i < height.length && j>i){
            int volume = Math.min(height[i],height[j])*distance(i,j);
            if(volume > maxVolume)
                maxVolume = volume;
            if(height[i] < height[j])
                i++;
            else
                j--;

        }
        return maxVolume;
    }

    public static int distance(int i, int j) {
        return j-i;
    }
}
