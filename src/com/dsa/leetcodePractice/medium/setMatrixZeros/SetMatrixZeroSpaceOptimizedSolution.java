package com.dsa.leetcodePractice.medium.setMatrixZeros;

public class SetMatrixZeroSpaceOptimizedSolution {
    class Solution {

        // Use First row to mark columns which need to be set to zero
        // Use First column to mark rows which need to be set to zero
        // Use two external boolean variables to mark if firstRow/firstColumn need to be zero

        public void setZeroes(int[][] matrix) {

            boolean firstRow = false;
            boolean firstColumn = false;
            //check if first row need to be zero
            for(int i=0; i<matrix[0].length; i++){
                if(matrix[0][i]==0){
                    firstRow = true;
                }
            }
            //check if first column need to be zero
            for(int i=0; i<matrix.length; i++){
                if(matrix[i][0] == 0){
                    firstColumn = true;
                }
            }


            //Iterate through matrix from 2nd row and 2nd column skipping first row and first column
            for(int row=1; row<matrix.length; row++){
                for(int column=1; column<matrix[row].length; column++){
                    if(matrix[row][column] == 0) {
                        matrix[row][0] = 0;
                        matrix[0][column] = 0;
                    }
                }
            }

            //Iterate first row and set columns zero
            for(int column=1; column< matrix[0].length; column++){
                if(matrix[0][column] == 0){
                    for(int row=1; row<matrix.length; row++){
                        matrix[row][column] = 0;
                    }
                }
            }

            //Iterate first column and set rows zero
            for(int row=1; row<matrix.length; row++){
                if(matrix[row][0] == 0){
                    for(int column=1; column<matrix[row].length; column++){
                        matrix[row][column] = 0;
                    }
                }
            }

            //set firstRow zero
            if(firstRow == true){
                for(int i=0; i<matrix[0].length; i++){
                    matrix[0][i] = 0;
                }
            }

            //set firstColumn zero
            if(firstColumn == true){
                for(int i=0; i<matrix.length; i++){
                    matrix[i][0] = 0;
                }
            }}


    }

}
