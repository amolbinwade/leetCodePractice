package com.dsa.leetcodePractice.easy.twoSum;

import java.util.Arrays;
import java.util.Hashtable;

public class HashTableSolution {

    public static void main(String[] args){

        int a[] = {3,4,7};
        int target = 10;

        HashTableSolution s = new HashTableSolution();
        int[] solution = s.twoSum(a, target);

        Arrays.stream(solution).forEach( x -> System.out.println(x));

    }

    public int[] twoSum(int[] nums, int target) {
        //hash table to store <value, index>
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        int[] solution = new int[2];

        for(int i=0; i < nums.length; i++){
            int offset = target - nums[i];
            // check if the offset (target-num[i]) is present in hash table
            //if present stop and return the index of both ints
            Integer targetIndex = table.get(offset) ;
            if(targetIndex != null){
                solution[0] = targetIndex;
                solution[1] = i;
                return  solution;
            }
            table.put(nums[i], i);
        }
        return  solution;
    }
}