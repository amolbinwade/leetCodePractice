package com.dsa.leetcodePractice.twopointers;


/***
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class ContainerWithMostWater {

    /**
     * Solution with two pointers. One starting at 0th index and other at last index.
     * area = minValue(i,j)*(j-i)
     * (j-i) is going to decrease by 1 in each step.
     * we can control minValue(i,j) by deciding to increment i or decrement j in each iteration.
     * So select such value which will increase potential for more water, which is to keep
     * the max of height[i] and height[j]
     * LEARNING : Understand the math formula with function. Identify which is the constant rate variable
     * and which variable can be controlled to get desired output. This will help in finding
     * condition to increment/decrement pointers.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int maxArea=0;
        int i=0, j=height.length-1;
        if(height.length==0)
            return 0;

        while(i<j) {
            if(getArea(height, i, j) > maxArea)
                maxArea = getArea(height, i, j);
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

    public static int getArea(int[] height, int i, int j){
        return Integer.min(height[i],height[j])*(j-i);
    }

}
