/*
  Name: Bastien Gliech
  CIS 303 Algorithm Analysis and Design
  Assignment: 1 - KthLargest class
  Due: February 1, 2018
*/

import java.util.*;
import java.io.*;

// SizeTestKthLargest
//
// Same implementation as TimeTestKthJava, changes array size instead of k
// Usage: java SizeTestKthLargest <max array size>

public class SizeTestKthLargest {

    public static void main (String [] args) throws Exception{    
  PrintStream ps = new PrintStream(new File("data.txt"));
  ps.println("size(n)\ttime(ms)");
        int arraySize = Integer.parseInt(args[0]);
  for (int k = 10000; k <= arraySize; k += 10000){
              int [] numbers = new int[k];
              TestKthLargest.fill(numbers);
              KthLargest.kthLargest(numbers, 1000, ps);
    }
  }
}   
