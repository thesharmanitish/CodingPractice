package com.interview.google;

/**
 * https://leetcode.com/problems/find-in-mountain-array/discuss/317607/JavaC%2B%2BPython-Triple-Binary-Search
 * 
 * https://assets.leetcode.com/users/images/33e46e16-46b6-4a0a-b396-edd4a56eeb61_1599025122.4799252.png
 * https://assets.leetcode.com/users/images/33e46e16-46b6-4a0a-b396-edd4a56eeb61_1599025122.4799252.png
 * 
 * You may recall that an array arr is a mountain array if and only if:
 * 
 * arr.length >= 3 There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i] arr[i] > arr[i + 1] > ... >
 * arr[arr.length - 1]
 * 
 * Given a mountain array mountainArr, return the minimum index such that
 * mountainArr.get(index) == target. If such an index does not exist, return -1.
 * 
 * You cannot access the mountain array directly. You may only access the array
 * using a MountainArray interface:
 * 
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * 
 * Submissions making more than 100 calls to MountainArray.get will be judged
 * Wrong Answer. Also, any solutions that attempt to circumvent the judge will
 * result in disqualification.
 * 
 * @author nisharma
 *
 */
interface MountainArrayInt {
     public default int get(int index) {
		return index;}

	public int length();
    }
public class FindInMountainArr {
	int findInMountainArray(int target, MountainArrayInt A) {
		int n = A.length(), l, r, m, peak = 0;
		// find index of peak
		l = 0;
		r = n - 1;
		while (l < r) {
			m = (l + r) / 2;
			if (A.get(m) < A.get(m + 1))
				l = peak = m + 1;
			else
				r = m;
		}
		// find target in the left of peak
		l = 0;
		r = peak;
		while (l <= r) {
			m = (l + r) / 2;
			if (A.get(m) < target)
				l = m + 1;
			else if (A.get(m) > target)
				r = m - 1;
			else
				return m;
		}
		// find target in the right of peak
		l = peak;
		r = n - 1;
		while (l <= r) {
			m = (l + r) / 2;
			if (A.get(m) > target)
				l = m + 1;
			else if (A.get(m) < target)
				r = m - 1;
			else
				return m;
		}
		return -1;
	}
//	     public int findInMountainArray(int target, MountainArray mountainArr) {
//	         int start = 0, end = mountainArr.length()-1;
//	         int ind = findPeek(mountainArr, start,end);
//	         System.out.print(ind);
//	         int firstTry =  bsearch(mountainArr,target, start,ind);
//	         if(firstTry==-1)
//	             firstTry =  bsearch(mountainArr,target, ind+1, end);

//	         return firstTry;
//	     }

//	     int findPeek(MountainArray mountainArr, int start, int end){

//	         while(start<end){
//	             int mid = start + (end-start) /2;
//	             if(mid <end && mountainArr.get(mid) >mountainArr.get(mid+1)){
//	                 end = mid;
//	             }else start =mid+1;

//	         }
//	         return start;

//	     }

//	     int bsearch(MountainArray mountainArr,int target, int start, int end){
//	         boolean isAsc = mountainArr.get(start) <=mountainArr.get(end) ? true: false;

//	             while(start<=end){
//	                 int mid = start + (end-start) /2;
//	                 if(mountainArr.get(mid) == target)
//	                     return mid;
//	                 if(isAsc){
//	                     if(target<mountainArr.get(mid)){
//	                         end = mid-1;
//	                     }else if(target> mountainArr.get(mid)){
//	                         start = mid+1;
//	                     }
//	                 }
//	                 else{

//	                     if(target>mountainArr.get(mid)){
//	                         end = mid-1;
//	                     }else if(target< mountainArr.get(mid)){
//	                         start = mid+1;
//	                     }

//	                 }

//	         }
//	         return -1;
//	     }
}
