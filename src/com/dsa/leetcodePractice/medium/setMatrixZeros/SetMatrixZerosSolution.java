package com.dsa.leetcodePractice.medium.setMatrixZeros;

public class SetMatrixZerosSolution {

    public void setZeroes(int[][] matrix) {
        //iterate through array by row -> column to find column index of 0s
        //make row 0 wherever we find 0
        //Iterate over rows of indices found for zeros and iterate over matrix row-wise setting zeros
        //step 1 to zeros
        int[] columnsIndexWithZeros = new int[matrix[0].length];
        int[] zeroRow = new int[matrix[0].length];
        for(int i=0; i < matrix.length; i++){
            boolean found = false;
            for(int j=0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    columnsIndexWithZeros[j] = 1;
                    found = true;
                }
            }
            if(found){
                matrix[i] = zeroRow;
            }

        }
        for(int i=0; i<columnsIndexWithZeros.length; i++){
            if(columnsIndexWithZeros[i] == 1){
                for(int j=0; j<matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

    }
}
