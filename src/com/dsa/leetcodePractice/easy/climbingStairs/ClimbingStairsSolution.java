package com.dsa.leetcodePractice.easy.climbingStairs;

import java.util.HashMap;
import java.util.Map;

/**
 * use divide and conquer strategy using recursive methods.
 * Some calls to recursive methods has duplicates. Cache such calls.
 */
public class ClimbingStairsSolution {

    public static void main(String[] args){
        ClimbingStairsSolution solution = new ClimbingStairsSolution();
        System.out.println(solution.climbStairs(45));
    }

    //Map to cache repeating combinations
    Map<Integer,Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        return getCombinations(0, n);
    }

    public int getCombinations(int startStep, int endStep){
        int val;
        //cache hit then return from cache
        if(cache.get(startStep) != null){
            return cache.get(startStep);
        }
        //if steps > 3 then divide
        if(endStep-startStep > 3){
            val =  getCombinations(startStep+1, endStep)
                    + getCombinations(startStep+2, endStep);

        } else if (endStep-startStep == 3){ //if steps <= 3 then return hardcoded predetermined values
            val = 3;
        } else if (endStep-startStep == 2) {
            val = 2;
        } else if(endStep-startStep == 1){
            val = 1;
        } else {
            val = 0;
        }
        cache.put(startStep, val);
        return val;
    }
}
