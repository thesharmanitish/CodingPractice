package com.interview.fb.matrix;

public class QuarterSumMaximize {
	// Java program to find maximum value of top N/2 x N/2
	// matrix using row and column reverse operations



		static int maxSum(int mat[][]) {
			int sum = 0;
			int R = mat.length;
			int C = mat[0].length;
			
			for (int i = 0; i < R / 2; i++) {
				for (int j = 0; j < C / 2; j++) {
					int R1 = i;
					int R2 = R-i-1;
					int C1 = j;
					int C2 = C-j-1;
					mat[i][j] = Math.max(Math.max(mat[R1][C1], mat[R1][C2]), Math.max(mat[R2][C1], mat[R2][C2]));
					sum+=mat[i][j];
				}
			}

			return sum;
		}

	// Driven Program
		public static void main(String[] args) {
			int mat[][] = {
				{112, 42, 83, 119},
				{56, 125, 56, 49},
				{15, 78, 101, 43},
				{62, 98, 114, 108}
			};

			System.out.println(maxSum(mat));

		}
	}
