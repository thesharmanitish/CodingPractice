package com.interview.google.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/**
 * Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, 
 * ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.
 * 
 * @author nisharma
 *
 */
class GridChallenge {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
    // Write your code here

        for(int i=0;i<grid.size();i++){
            char[] c = grid.get(i).toCharArray();
            Arrays.sort(c);
            grid.set(i, String.valueOf(c));
        }
        for(int i=0;i<grid.size()-1;i++){
            for(int j=0;j<grid.get(i).length();j++){
                if(grid.get(i).charAt(j)>grid.get(i+1).charAt(j))
                return "NO";
            }
        }
        return "YES";
    }

}

