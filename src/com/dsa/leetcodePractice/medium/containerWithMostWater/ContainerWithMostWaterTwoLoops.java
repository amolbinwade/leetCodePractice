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
 * Two loops: first starts from 0th position, second inner loop starts from 1st.
 * Inner loop calculates volume of water for each combination and if > maxVolume then
 * updates maxVolume with volume.
 * This is O(n^2) time complexity and so not an optimum solution.
 * This solution passed most of the tests. But not accepted for large input test case due
 * to time complexity.
 */

public class ContainerWithMostWaterTwoLoops {

    public int maxArea(int[] height) {

        //water volume = min(p, q) * distance(p, q)
        int maxVolume=0;

        for(int i=0; i<height.length; i++){
            for(int j=height.length-1; j>i; j--){
                int volume = min(height[i],height[j])*distance(i,j);
                if(volume > maxVolume){
                    maxVolume = volume;
                }
            }
        }
        return maxVolume;
    }

    public static int min(int p, int q){
        if(p < q)
            return p;
        else
            return q;
    }

    public static int distance(int i, int j) {
        return j-i;
    }
}
