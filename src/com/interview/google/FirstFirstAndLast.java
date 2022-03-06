package com.interview.google;

/*public class FirstFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        if(nums.length ==0) return ret;
        
    }*/
//}
//
//
//Approach 4, Golden-section search
//
//It's gurentee only one peak, we can apply golden-section search.
//
//    def peakIndexInMountainArray(self, A):
//        def gold1(l, r):
//            return l + int(round((r - l) * 0.382))
//
//        def gold2(l, r):
//            return l + int(round((r - l) * 0.618))
//        l, r = 0, len(A) - 1
//        x1, x2 = gold1(l, r), gold2(l, r)
//        while x1 < x2:
//            if A[x1] < A[x2]:
//                l = x1
//                x1 = x2
//                x2 = gold1(x1, r)
//            else:
//                r = x2
//                x2 = x1
//                x1 = gold2(l, x2)
//        return A.index(max(A[l:r + 1]), l)
