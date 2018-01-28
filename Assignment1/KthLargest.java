/*
    Name: Bastien Gliech
    CIS 303 Algorithm Analysis and Design
    Assignment: 1 - KthLargest class
    Due: February 1, 2018
*/

import java.util.*;
import java.io.*;

public class KthLargest {

    /**
    * Method to find kth largest value in an array
    *
    * Pre-condition:
    *       1. a is completely filled with integers between 0 and 99 inclusive
    *       2. Size of array > k
    *       3. 0 < k < range of values in array
    * Post-condition: The kth largest value is returned  
    */

    public static int kthLargest(int [] a, int k, PrintStream ps) {

        int size = a.length;

        // Starting time
        long start = System.currentTimeMillis();
        
        // Temporary maximum variable 
        int max = a[0];

        // Finds the initial largest value
        for (int i = 1; i < size; i++){
            if (a[i] > max){
                max = a[i];
            }
        }

        // Finds the largest value under the previous largest k-1 times
        for (int j = 1; j < k; j++){

            // Makes sure there are no duplicate values
            int temp = 0;

            // Finds the first value in array that is less than previous max
            while (a[temp] >= max){
                temp++;
            }

            // Testing value
            int currmax = a[temp]; 

            // finds max value under previous max
            for (int i = temp; i < size; i++){
                if (a[i] > currmax && a[i] < max){
                    currmax = a[i];
                }
            }

            // New maximum for previous algorithm
            max = currmax;

        }
        
        // Stopping time, prints k and runtime
        long stop = System.currentTimeMillis();
        long time = stop-start;
        ps.println(k + "\t" +   time);
        
        // Returns kth largest value
        return max;
    }
  
}   
