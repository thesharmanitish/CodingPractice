
public class Test {

	// Driver Code
	public static void main(String[] args) {
		int a[] = { 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1 };
		int n = a.length;
//		System.out.println(minSwaps(a, n));
		int[][] b = { {0, 1, -1},{ 1, 0, -1}, {1, 1, 1} };
		cherryPickup(b);

	}

	
    private static int[][] dp ;
    public static int cherryPickup(int[][] grid) {
        dp = new int[grid.length+1][grid.length+1];
        for(int i=1;i<=grid.length;i++){
            for(int j=1;j<=grid.length;j++){
                    if(grid[i-1][j-1] ==1)
                        dp[i][j] = 1+Math.max(dp[i-1][j],dp[i][j-1]);
                    else if(grid[i-1][j-1] ==0)
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    else if(grid[i-1][j-1] ==-1)
                        dp[i][j] = Integer.MIN_VALUE;
            
                }
        }
        int max = dp[grid.length][grid.length], i=grid.length, j=grid.length;
        while(i>1 && j>1){
            if(dp[i][j-1]>dp[i-1][j]){
                if(dp[i-1][j]!=Integer.MIN_VALUE) {
                    max+= grid[i-2][j-1];
                        i--;
                    }
                else j--;
                }
            else {
                if(dp[i][j-1]!=Integer.MIN_VALUE){
                    max+= grid[i-1][j-2]    ;   
                     j--;   
                    }
                else i--;
                    
                }
            
        }
        return max;
    }
    
	private static int minSwaps(int[] a, int n) {
		int ones = 0;
		for (int i = 0; i < n; i++)
			if (a[i] == 1)
				ones++;

		int numOfSwap = 0;
		for (int i = 0; i < ones; i++) {
			if (a[i] == 0)
				numOfSwap++;

		}
		int min = numOfSwap;
		for (int i = ones; i < n; i++) {

			if (a[ones] == 0)
				numOfSwap++;
			if (a[i - ones] == 0)
				numOfSwap--;
			min = Math.min(min, numOfSwap);
		}

		return min;
	}
}
