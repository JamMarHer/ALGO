/////////////////////////////////////////////////////////////////////////
//  CIS 303 Algorithm Analysis and Design
//  Spring 2018
//  Assignment 4, Chapter 3
//  Client code for modified binary search
//  Modified by L. Grabowski 2/12/2018
//
// This client program tests an implementation of binary search by
//      testing selected test cases with the binary search implementation
//      against a sequential search.
//
//  DO NOT MODIFY THIS FILE
/////////////////////////////////////////////////////////////////////////

import java.util.*;

public class BinTest {
    public static int SEQ_ITS;

    public static void main (String [] args) {
        int [] a = new int[1000000];
        fillRandom(a);
        System.out.println("\n*** Random array, size 1,000,000, find 9");
        test (a, 9);

        System.out.println("\n*** Array, size 1,000,000, all 9s,  find 9");
        for(int i =0; i < 1000000; i++)
            a[i] = 9;
        test (a, 9);

        System.out.println("\n*** Array, size 1,000,000, all 2s,  find 9");
        for(int i =0; i < 1000000; i++)
            a[i] = 2;
        test (a, 9);

        System.out.println("\n*** Array, size 1,000,000, all 2s except for one final 9,  find 9");
        a[999999] = 9;
        test (a, 9);

        System.out.println("\n*** Array, size 1,000,000, all 9s except for one 2 at the beginnng,  find 9");
        for(int i =0; i < 1000000; i++)
            a[i] = 9;
        a[0] = 2;
        test (a, 9);
    }

    // test: tests binary search implementation against sequential search
    //      to find the first (lowest index) occurrence of the target
    // Precondition: Array a exists and is populated. target has a value.
    // Postcondition: Binary search has returned result and has been compared
    //      to result of sequential search. Results are output to display.
    public static void test (int [] a, int target) {
        try {
            System.out.println("\nUsing binSearch, smallest position of " + 
                               target +": " + 
                                BinSearch.binSearch(a, target));
        } catch (Exception e) {
            System.out.println (e);
        } catch (Error e) {
            System.out.println (e);
	}

        System.out.println("VERIFY: Using seqSearch, smallest position of " + 
                            target +  ": " + 
                            seqSearch(a, target));
        System.out.println("BIN_CALLS " + BinSearch.BIN_CALLS);
        System.out.println("SEQ_ITS " + SEQ_ITS);

    }

    // fillRandom: Fills array a with random number of copies of
    //     integer values
    // Precondition: Array a exists and is of size 100000.
    // Postcondition: Array a has been filled with random numbers
    //      of copies of sorted values.
    public static void fillRandom (int [] a) {
        Random rand = new Random();
        rand.setSeed(13);
        int i = 0;
        int value = 1;
        while (i < a.length) {
            int times = rand.nextInt(100000);
            int count = 0;
            while (i < a.length && count < times) {
                a[i++] = value;
                count++;
            }
            value++;
        }
    }

    // seqSearch: implements sequential search of an array
    //      for target
    // Precondition: Array a exists, target has a value.
    // Postcondition: Either the lowest position of target
    //      in the array has been returned, or -1 if target
    //      is not in the array.
    public static int seqSearch(int [] a, int target) {
        SEQ_ITS = 0;
	for (int i = 0; i < a.length; i++) {
            SEQ_ITS++;
            if (a[i] == target) return i;
	}
        return -1;
    }
}
