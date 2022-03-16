package com.interview.google.greedy;
/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 * 
 * @author nisharma
 *
 */
public class MaxSumSubarray {
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE, curMax = 0;
		if (nums.length <= 1)
			return nums[0];
		for (int i = 0; i < nums.length; i++) {
			curMax = curMax + nums[i];
			max = Math.max(max, curMax);
			if (curMax < 0)
				curMax = 0;
		}

		return max;

//	        int max = 0, curMax = 0, min= Integer.MIN_VALUE;
//	        boolean allNeg = true;
//	        if(nums.length ==1)
//	            return nums[0];
//	        
//	        for(int num:nums){
//	            min = Math.max(num, min);
//	            
//	            if(num>0) 
//	                allNeg = false;
//	            if(max + num <0){
//	                max = 0;
//	                continue;
//	            }
//	            else max+=num;
//	            curMax = Math.max(curMax, max);
//	        }
//	        if(allNeg)
//	            return min;
//	        return curMax;
	}
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
	 * 
	 * @author nisharma
	 *
	 */
	
	class BestTimeForStock {
	    public int maxProfit(int[] prices) {
	        int prev = prices[0], maxDiff = Integer.MIN_VALUE;
	        
	        for(int i=1;i<prices.length;i++){
	            int  diff=prices[i]-prev;
	            maxDiff = Math.max(diff, maxDiff);
	            if(diff<0)
	                prev = prices[i];
	        }
	        return maxDiff>0?maxDiff:0;
	        
	    }
	}
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
	 * 
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        int res = 0, max = Integer.MIN_VALUE, prev = prices[0];
        for(int i=1;i<prices.length;i++){
            int diff = prices[i] - prev;
            max = Math.max(max, diff);
            if(diff>0)
                res+=max;
            
            prev = prices[i];
             max= 0;
        }
        return res;
    }
    

//  Here, the oneBuy keeps track of the lowest price, and oneBuyOneSell keeps track of the biggest profit we could get.
//Then the tricky part comes, how to handle the twoBuy? Suppose in real life, you have bought and sold a stock and made $100 dollar profit. When you want to purchase a stock which costs you $300 dollars, how would you think this? You must think, um, I have made $100 profit, so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
//There we go, you got the idea how we calculate twoBuy!! We just minimize the cost again!! The twoBuyTwoSell is just making as much profit as possible.
//Hope this explanation helps other people to understand this!
    
    public static int max2Profit(int[] prices) {
    	  int oneBuyOneSell = 0;
    	  int twoBuyTwoSell = 0;
    	  int oneBuy = Integer.MAX_VALUE;
    	  int twoBuy = Integer.MAX_VALUE;;
    	  
    	  for(int i = 0; i < prices.length; i++) {
    	    int p = prices[i];
    	    oneBuy = Math.min(oneBuy, p);
    	    oneBuyOneSell = Math.max(oneBuyOneSell, p - oneBuy);
    	    twoBuy = Math.min(twoBuy, p - oneBuyOneSell);
    	    twoBuyTwoSell = Math.max(twoBuyTwoSell, p - twoBuy);
    	  }
    	  return twoBuyTwoSell;
    }
    public static void main(String[] args) {
		int[] ar  = {3,3,5,0,0,3,1,4};
		System.out.println(max2Profit(ar));
	}
}