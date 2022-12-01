package com.interview.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	    public List<List<String>> solveNQueens(int n) {
	        boolean[][] chessMatrix = new boolean[n][n];
	        List<List<String>> res = new ArrayList<>();
	        if(solveNQueensHelper(chessMatrix, 0, 0)){
	            for(int i=0;i<n;i++){
	                List<String> temp = new ArrayList<>();
	                for(int j=0;j<n;j++){
	                    if(chessMatrix[i][j])
	                        temp.add("Q");
	                    else
	                        temp.add(".");
	                }
	                res.add(temp);
	            }
	        }
	        return res;
	        
	    }
	    
	    public boolean solveNQueensHelper(boolean[][] chess, int row, int col) {
	          if(row>= chess.length || col >= chess.length)  
	              return false;
	        
	          for(int i=0;i<chess.length;i++) {
	              if(chess[row][col] || chess[row][i] || chess[i][col])
	                  solveNQueensHelper(chess, row+1, col);
	          }
	        
	          chess[row][col]  = true;
	          
	          boolean flag = solveNQueensHelper(chess, row, col+1);
	          
	          if(!flag){
	              chess[row][col]  = false;
	              solveNQueensHelper(chess, row+1, col);
	          }
	        return true;
	          
	    }
	    public static void main(String[] args) {
			new NQueen().solveNQueens(4);
		}
	}