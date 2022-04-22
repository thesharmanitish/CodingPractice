package com.interview.fb.matrix;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/rotate-image/submissions/
 * 
 * @author nisharma
 *
 */
public class RotateMatrix {
    // public void rotate(int[][] matrix) {
    //     int n= matrix.length;
    //     for(int i=0;i<n/2;i++){
    //         for(int j=i;j<n-1-i;j++){
    //             // System.out.print(matrix[row][col]);
    //             swap(matrix, i,j,j,n-i-1 );
    //             swap(matrix, i,j,n-i-1,n-j-1 );
    //             swap(matrix, i,j,n-j-1,i );
    //             // int tmp = matrix[i][j];
    //             // matrix[i][j] = matrix[n-j-1][i];
    //             // matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
    //             // matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
    //             // matrix[j][n-i-1]=tmp;                
    //         }
    //     }
    // }
    public void rotate(int[][] mat) {
    	
        for (int i = 0, j = mat.length - 1; i < j; ++i, --j) { // reverse rows order.
            int[] tmp = mat[i];
            mat[i] = mat[j];
            mat[j] = tmp;
        } 
        for (int r = 0, R = mat.length; r < R; ++r) { // transpose.
            for (int c = r + 1; c < R; ++c) {
                int tmp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = tmp;
            }
        }
    }
    public static void main(String[] args) {
		int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
		new RotateMatrix().rotate(arr);
	}
}
