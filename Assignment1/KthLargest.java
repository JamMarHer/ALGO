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
    * Method to find kth largest element in an array
    *
    * Pre-condition:
    *       1. a is completely filled with integers
    *       2. Size of array > k
    * Post-condition: The kth largest element is returned  
    */

    public static int kthLargest(int [] a, int k, PrintStream ps) {

        // Starting time
        long start = System.currentTimeMillis();
        
        // Temporary maximum variable 
        int max = a[0];

        // Variable responsible for finding kth largest element
        int count = 0;

        // Finds the initial largest value
        for (int i = 1; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }

        // Ensures that max is above any value in array
        max++;

        // Instanciating variables for next part of algorithm
        int index, tempmax;

        // While k elements have not yet been examined
        while (count < k){


            // Ensures that testing value will always be under max
            index = 0;
            while (a[index] > max){
                index++;
            }

            // tempmax is less than max
            tempmax = a[index];

            // Finds largest value under max
            for (int i = index; i < a.length; i++){
                if (a[i] > tempmax && a[i] < max){
                    tempmax = a[i];
                }
            }

            // Examines each element
            for (int i = 0; i < a.length; i++){

                // Increases counter if an instance of the value appears
                if (a[i] == tempmax){
                    count++;
                }
            }

            // Ensures the loop runs with tempmax as the new maximum
            max = tempmax;
        }
        
        // Stopping time, prints k and runtime
        long stop = System.currentTimeMillis();
        long time = stop-start;
        ps.println(k + "\t" +   time);
        
        // Returns kth largest value
        return max;
    }
}   
