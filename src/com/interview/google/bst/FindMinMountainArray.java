package com.interview.google.bst;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48808/My-pretty-simple-code-to-solve-it
 * 
 * 
 * we can enum all the basic scenarios of this problems - sorted array with duplicates and rotated:

case 	a[start] 	? 	a[mid] 	? 	a[end] 	example
1 		> 		= 		[4 2 3 3 3]
2 		> 		< 		[4 2 3 3 4]
3 		= 		< 		[3 3 3 1 2]
4 		= 		= 		[3 3 3 2 3]
5 		< 		< 		[1 2 3 3 4]
6 		< 		= 		[1 2 3 3 3]
7 		< 		> 		[3 4 5 1 2]
8 		= 		> 		[3 3 3 1 2]

the only case that will not happen is a[start] > a[mid] > a[end]
then as @YingnanZhou mentioned, why comparing middle element with a[end], instead of comparing with a[start]?

    if we compare a[s] with a[mid], there are 3 potential cases:
        (1) < , [4 5 6 1 2] [1 2 3]
        (2) = , [3 1 3 3 3] [2 2 2 1 2]
        (3) > , [7 3 4 5 6] [3 1 2 3 4]
        for (1)(2), min can be on either half and can be at any position
        for (3), min must be landed in [start, mid] inclusively, so we can set e to mid
        but in else we still cannot determine which half to go or which element to skip
    if we compare a[mid] with a[e], also 3 scenarios:
        (1) < , [5 1 2 3 4] [4 5 1 2 3] must be in left half [s, mid]
        (2) = , [1 2 3 3 3] [3 3 3 1 3]
        (3) > , [3 4 5 2 3]
        for (1) the target must be in left half [s,mid]
        for (2) not known
        for (3) must be in right half

 * @author nisharma
 *
 */
public class FindMinMountainArray {

	public static  int findMin(int[] nums) {

        if(nums.length ==1 || nums[0] < nums[nums.length-1])
            return nums[0];
        int start = 0, end = nums.length-1, res=-1;
        while(start<end){
            int mid= start+ (end-start)/2;

            if( nums[mid]<nums[end])
                end =mid;
            else if(nums[mid]>nums[end])
                start = mid+1;
            else 
            {
                if(mid >=1 && nums[mid-1]>nums[mid])
                  return nums[mid];
                else
                    end--;
            }
        }
        System.out.print(start + " "+ end);
        return nums[end];
     }
	public static void main(String[] args) {
		int[] arr = {2,2,2,0,1};
		System.out.println(findMin(arr));
	}
}
