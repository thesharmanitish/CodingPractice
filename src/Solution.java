import java.util.List;

// java program to find largest number
// smaller than equal to n with m set
// bits then m-1 0 bits.
public class Solution {
	
	// Function to find minimum swaps
	// to group all 1's together
	public static int minimumCoinFlips(String coins) 
	{
		   char[] arr = coins.toCharArray();
	        int n = arr.length;
	        int numberOfTs = 0;

	        for (int i = 0; i < n; i++) {
	            if (arr[i] == 'H')
	                numberOfTs++;
	        }
	        
	        // length of subarray to check for
	        int x = numberOfTs;
	        
	        int count_Ts = 0, maxTs,i=0;



	        for( i = n-1; i >= x; i--){
	            if(arr[i] == 'H' )
	                count_Ts+=1;
	            
	        }
	           
	        boolean flag =true;
	        for(i = x-1; i >= 0; i--){
	            if(arr[i] == 'T' && flag)
	                continue;
	            
	            else if(arr[i] == 'H' && flag) {
	            	if(i>=0 && arr[i-1] == 'T')
	            		count_Ts+=1;
	            	else flag =false;
	                
	            }
	            else if(arr[i] == 'T' && !flag) count_Ts+=1;
	        }     
	        return count_Ts;
	}
	
    public static long getTotalImbalance(List<Integer> weight) {
    // Write your code here
    int sum=0; 
    for(Integer s:weight)
    	sum+=s;
    
    if(weight.size()<2) return -1;
    else if (weight.size()==2) return Math.abs(weight.get(0) -weight.get(1));
    
    else {
    	
    	dp = new boolean[weight.size()][weight.size()];
    	subsetSum(weight,sum);
    }
    	return 0;
    }
    static boolean[][] dp;
	private static void subsetSum(List<Integer> weight, int sum) {
		
		for(int i=0;i<weight.size();i++) {
			for(int j=0;j<weight.size();j++) {
				if(weight.get(0)<=sum){
					dp[i][j] = dp[i-1][j-weight.get(i)]|| dp[i-1][j];
				}
				else 
					dp[i][j] = dp[i-1][j];
			}
		}
		
	}

	// Driver code
	public static void main(String args[])
	{
		int a[] = new int[]{0, 0, 1, 0,
							1, 1, 0, 0, 1};
		int n = a.length;
		
		System.out.println(minimumCoinFlips("THTHTTTTHTTHHTHHHHTTTHTTHHHHHHTTTTHTHTHTHHHHTTHHTTTTHTHTHTHTTTHTTHTHHTTTHHHHTTHHHHHHHTHTTTHHTTTTTHHHHTHHTHTTHHHTTTHTTHTHHHTHHTTHTHHTTTTHTHHTTHHHTTHHHTHTHHHHHHTHTHTTTHTHHHHTTHTTHHTTTTHTTTHTTHTTHHHTHTTHTTHHHTTTTHTTHHTHTHTHHTTHHTTTTTTHTHHHHTHHTHHTTHTTTHTTHHHHTTHTHHTTHTHTHHTTHTTTHHTTHTHTHHTTHTTTTHTHTHTHTHTHHTTTTHTHHHTHHTHTHHHTHTTTTHTHTHHTTTHHTTTHTHTHHTTTTHTTTHTHHHTTHTTHHTHTHHTHHTHHTTTHTTTHHHHHHHHTTTHTHTHHHHTHHTHTTHTHTHHHHTHHTHHTTTTHHHTTHHTTTHHTTHTTHTTHHHTTHTTTHHHHHTTTTTHHTTTTTHTHHHHHHTHHHHHTHHTTHHHTTHHHTTTTTHHHHTTHHHHHTT"));
	}
}

// This code is contributed by Sam007

