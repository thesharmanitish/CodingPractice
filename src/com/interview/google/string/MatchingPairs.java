package com.interview.google.string;

import java.util.HashMap;

public class MatchingPairs {
  // Add any helper functions you may need here
  

  int matchingPairs(String s, String t) {
    // Write your code here
    int count = 0;
    char[] sch = s.toCharArray(), tch = t.toCharArray();
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i=0;i<s.length();i++){
      if(sch[i] == tch[i]){
        sch[i] = '-';
        tch[i] = '-';
          
        }
      else{ count++;
           map.put(tch[i],i);
          }
      
      
    }
    if(count ==0)
      return s.length()-2;
    
    int res = 0;
    for(int i=0;i<s.length();i++){
        if(sch[i]=='-')
            continue;
      Integer  x = map.get(sch[i]);
      if(x != null) {
       if(sch[x] ==tch[i]){
          res = 2;
            break;
       }
       res=1;
       break;
     }
    }
    return s.length()-count+res; 
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() {
    String s_1 = "abcde";
    String t_1 = "adcbe";
    int expected_1 = 5;
    int output_1 = matchingPairs(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "abcd";
    String t_2 = "abcd";
    int expected_2 = 2;
    int output_2 = matchingPairs(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new MatchingPairs().run();
  }
}