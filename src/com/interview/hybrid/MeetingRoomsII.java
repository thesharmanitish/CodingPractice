package com.interview.hybrid;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Given an array of meeting time intervals intervals where intervals[i] =
 * [starti, endi], return the minimum number of conference rooms required.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[0,30],[5,10],[15,20]] Output: 2
 * 
 * Example 2:
 * 
 * Input: intervals = [[7,10],[2,4]] Output: 1
 * 
 * @author nisharma
 *
 */
public class MeetingRoomsII {
	    public int minMeetingRooms(int[][] intervals) {
	        
	        // GreedyApproach
//	         if (intervals == null || intervals.length == 0) {
//	             return 0;
//	         }
	        
//	         // Get starts and ends separately
//	         int len = intervals.length;
//	         int[] starts = new int[len];
//	         int[] ends = new int[len];
//	         for (int i = 0; i < len; i++) {
//	             starts[i] = intervals[i][0];
//	             ends[i] = intervals[i][1];
//	         }
	        
//	         // Sort starts and ends array
//	         Arrays.sort(starts);
//	         Arrays.sort(ends);
	        
//	         // Find min needed rooms
//	         int rooms = 0;
	        
//	         for(int si=0, ei = 0; si<intervals.length;si++){
//	             if(starts[si] < ends[ei])
//	                 rooms++;
//	             else
//	                 ei++;
//	         }
	        
//	         return rooms;
	        
	        
	        // PriorityQueue way
	        
	        Arrays.sort(intervals, (a,b)->{ return a[0]-b[0];});
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{ return a-b;});
	        
	        pq.offer(intervals[0][1]);
	        for(int i=1;i<intervals.length;i++){
	            if(pq.peek()<= intervals[i][0])
	                pq.poll();
	            pq.offer(intervals[i][1]);
	        }
	        return pq.size();
	    }
	}
