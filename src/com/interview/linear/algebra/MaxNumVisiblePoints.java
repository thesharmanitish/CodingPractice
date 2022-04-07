package com.interview.linear.algebra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *  Rotating Camera in forest with aperature angle find (angle) max trees which can be shown to camera
 *  Klarna Interview Question 
 *  
 * @author nisharma
 *
 */
public class MaxNumVisiblePoints {
    public static  int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int count = 0;
        List<Double> anglesList = new ArrayList<>();
        for(List<Integer> p:points){
            int dx = p.get(0)-location.get(0);
            int dy = p.get(1)-location.get(1);
            if(dx ==0 && dy ==0){
                count++;
                continue;
            }
                
            anglesList.add(Math.atan2(dy,dx)*(180 / Math.PI));
        }
        Collections.sort(anglesList);
        List<Double> tmp = new ArrayList<>(anglesList);
        for (double d : anglesList) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    
        
    }
    public static void main(String[] args) {
    	List<List<Integer>> arr = Arrays.asList(Arrays.asList(0,0),Arrays.asList(0,2));
    	visiblePoints(arr, 90, Arrays.asList(1,1));
	}
}
