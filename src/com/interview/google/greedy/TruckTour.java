package com.interview.google.greedy;

import java.util.Arrays;
import java.util.List;

public class TruckTour {
	public static int truckTour(List<List<Integer>> petrolpumps) {

		int start = 0, end = 1, n = petrolpumps.size();
		int capacity = 0;
		capacity += petrolpumps.get(start).get(0) - petrolpumps.get(start).get(1);
		while (start < end) {

			if (capacity < 0) {
				
				capacity -= petrolpumps.get(end).get(0) - petrolpumps.get(end).get(1);
				start = end;
				if (start == 0)
					return -1;
			}
			capacity += petrolpumps.get(end).get(0) - petrolpumps.get(end).get(1);
			end = (end + 1) % n;
		}
		return start;

	}

	public static int truckTourOptimized(List<List<Integer>> petrolpumps) {

		int start = 0, deficit = 0, n = petrolpumps.size();
		int capacity = 0;
		for (int i = 0; i < n; i++) {
			capacity += petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1);
			if (capacity < 0) {
				// If this particular step is not done then the
				// between steps would be redundant
				start = i + 1;
				deficit += capacity;
				capacity = 0;
			}
		}
		return (capacity + deficit >= 0) ? start : -1;
	}

	public static void main(String[] args) {
		List<List<Integer>> al = Arrays.asList(Arrays.asList(5, 5), Arrays.asList(2, 3), Arrays.asList(4, 3));
		System.out.println(truckTour(al));
	}
}
