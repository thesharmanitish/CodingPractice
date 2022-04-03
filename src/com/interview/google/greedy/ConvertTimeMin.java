package com.interview.google.greedy;

/**
 * 
 * https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/submissions/
 * 
 * @author nisharma
 *
 */
public class ConvertTimeMin {
	public int convertTime(String current, String correct) {
		String[] cu = current.split(":");
		String[] co = correct.split(":");

		int h = Integer.parseInt(co[0]) - Integer.parseInt(cu[0]);
		int count = 0;
		int m = Integer.parseInt(co[1]) - Integer.parseInt(cu[1]);
		if (h == 0 && m == 0)
			return 0;
		else if (h == 0) {
			return logic(m);
		}

		if (m >= 0) {
			count = h;

		} else if (m < 0) {
			count = h - 1;
			m = 60 - Integer.parseInt(cu[1]) + Integer.parseInt(co[1]);
		}
		count += logic(m);
		return count;
	}

	public int logic(int m) {
		int count = 0;
		if (m >= 15) {
			count += m / 15;
			m = m % 15;
		}
		if (m >= 5) {
			count += m / 5;
			m = m % 5;
		}
		count += m;
		return count;
	}
	
//    int curr_hour = stoi(current.substr(0,2));
//    int curr_min  = stoi(current.substr(3,2));
//    int co_hour = stoi(correct.substr(0,2));
//    int co_min  = stoi(correct.substr(3,2));
//    
//   
//    int h_diff = co_hour - curr_hour;
//    int min_diff = co_min - curr_min;
//    
//    int total = h_diff*60 + min_diff;   //Calculate The Total Minutes
//    vector<int>time{1,5,15,60};
//    
//    int op = 0;                                    // Perform the Greedy Operation
//    for(int i = time.size() -1;i>=0;i--){
//        if(total >= time[i] && total >0){
//            op+=total/time[i]; 
//            total = total%time[i];
//        }
//    }
//   
//    
//    
//    return op;
//}

}
