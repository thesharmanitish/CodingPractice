package com.interview.google;

public class CircularTree {
	public static long maxFruits(long arr[], int n, int m) {
		long sum=0, maxSum;
		for(int i=0;i<m;i++)
			sum+=arr[i];
		maxSum = sum;
		for(int i=m;i<n;i++) {
			sum = sum +arr[i]-arr[i-m];
			if(maxSum<sum)
				maxSum = sum;
		}
		for(int i=0;i<m;i++) {
			sum += arr[i]-arr[m-i];
			if(maxSum<sum)
				maxSum = sum;
		}
		return maxSum;	
	}
	public static  int peakElement(int[] arr,int n)
    {
		
		/**
		 * Approach 4, Golden-section search
		 * It's gurentee only one peak, we can apply golden-section search.
		 */
		
//	    def peakIndexInMountainArray(self, A):
//	        def gold1(l, r):
//	            return l + int(round((r - l) * 0.382))
//
//	        def gold2(l, r):
//	            return l + int(round((r - l) * 0.618))
//	        l, r = 0, len(A) - 1
//	        x1, x2 = gold1(l, r), gold2(l, r)
//	        while x1 < x2:
//	            if A[x1] < A[x2]:
//	                l = x1
//	                x1 = x2
//	                x2 = gold1(x1, r)
//	            else:
//	                r = x2
//	                x2 = x1
//	                x1 = gold2(l, x2)
//	        return A.index(max(A[l:r + 1]), l)
//	        		
        
              // Your code here
      int l=0,r=n-1,mid;
      while(l<r)
      {
          mid = l + (r-l) / 2;
          if(arr[mid+1]>arr[mid])
          {
              l = mid+1;
          }
          else
          {
              r = mid;
          }
      }
      return r;
//      
//          int max = Integer.MIN_VALUE, ind = -1;
//          for(int i=0;i<n;i++){
//              if(max<arr[i]){
//                  max= arr[i];
//                 ind = i;
//                  }
//           }
//          return ind;
    }
	
	public static void main(String[] args) {
		long[] arr = {1544,650,192,821,1903,810,1715};
		int[] peek = {1,2,1,1,1,1};
//		System.out.println(maxFruits(arr, 7, 6));
		System.out.println(peakElement(peek, 6));
	}
}