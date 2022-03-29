package com.interview.google.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
	Integer val;
	Integer ind;

	public Pair() {

	}

	public Pair(Integer val, Integer ind) {
		this.val = val;
		this.ind = ind;
	}

	public Pair getPair(int ind) {
		return this;
	}
}
/**
 * 
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * @author nisharma
 *
 */
public class SlidingWindowMax {
	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		Deque<Integer> dq = new LinkedList<Integer>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int i;
		for (i = 0; i < B; i++) {
			while (!dq.isEmpty() && A.get(i) >= A.get(dq.peekLast())) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		if (B == A.size()) {
			ar.add(A.get(dq.peek()));
			return ar;
		}
		for (; i < A.size(); i++) {
			ar.add(A.get(dq.peek()));
			while (!dq.isEmpty() && dq.peek() <= i - B) {
				dq.removeFirst();
			}
			while (!dq.isEmpty() && A.get(dq.peekLast()) <= A.get(i)) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		ar.add(A.get(dq.peek()));
		return ar;
	}

	/**
	 *  Below fails in test cases where window has below structure.
	 *  xxxx 45 xx 49 xx 45
	 *  
	 *  after 49 both 45 will be removed as sliding window deletes duplicates 
	 *  
	 * @param args
	 */
//	
//	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
//		Pair p = new Pair();
//		
//		
//        PriorityQueue<Pair> q = new PriorityQueue<>((o1,o2)-> {return o2.val-o1.val;});
//        ArrayList<Integer> res = new ArrayList<>();
//        q.add(new Pair(A.get(0),0));
//        for(int i=1;i<B;i++){
//            if(A.get(i)>q.peek().val)
//                q.remove();
//            q.add( new Pair(A.get(i),i));
//        }
//        
//        res.add(q.peek().val);
//        for(int i=B,j=0;i<A.size();i++){
//                if(!q.isEmpty() && A.get(i)>q.peek().val)
//                    q.remove();
//                q.remove();
//                q.add( new Pair(A.get(i),i));
//                
//                res.add(q.peek().val);
//                
//        }
//    
//        return res;
//        }
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(90, 767, 90, 777, 463, 196, 984, 277, 451, 643, 403, 316, 451, 967, 683, 786,
				167, 372, 758, 402, 325, 431, 351, 351, 158, 663, 244, 559, 345, 759, 924, 585, 509, 397, 540, 869, 997,
				670, 375, 180, 48, 936, 203, 8, 598, 703, 733, 333, 414, 377, 496, 351, 910, 685, 612, 773, 571, 24,
				679, 174, 644, 639, 544, 1, 884, 982, 447, 670, 251, 868, 815, 467, 386, 932, 178, 295, 957, 757, 124,
				932, 342, 301, 406, 259, 943, 79, 313, 218);
		slidingMaximum(arr, 7).stream().forEach(System.out::println);
	}
}
