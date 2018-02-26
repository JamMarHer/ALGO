/////////////////////////////////////////////////////////////////////////
//  Name: Bastien Gliech
//  CIS 303 Algorithm Analysis and Design
//  Assignment: 4 - BinSearch
//  Due: February 27, 2018
//
//  Algorithm specifics discussed with Alex Olesen
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
//  CIS 303 Algorithm Analysis and Design
//  Spring 2018
//  Assignment 2, Chapter 3
//  Starter code for modified binary search
//  Modified 2/12/2018 by L. Grabowski
//  This file currently contains a skeleton for implementing binary
//      search.
/////////////////////////////////////////////////////////////////////////

import java.util.*;

// BinSearch is a binary search algorithm that searches an integer array for 
//    the index of the first occurance of a value.
public class BinSearch {

  // Do not remove or modify the following line of code
  public static int BIN_CALLS;
  
  /** Initial call for binary search
   *
   * @param: int[] a -- array to be searched
   *         int target -- target value
   * @pre: size of int[] a > 0
   * @post: index of first occurance of target is returned, -1 if not found
   */
  public static int binSearch(int [] a, int target) {
    
    // initializes call counter
    BIN_CALLS = 0;

    // binSearch recursive method
    return binSearch(a, target, 0, a.length-1); 
  }
  
  /** Recursive call for binary search
   *
   * @param: int[] a -- array to be searched
   *         int target -- target value
   *         int l -- lower bound
   *         int r -- upper bound
   * @pre: 1. target value is not below value at left index
   *       2. right and left indices are within the array range
   * @post: index of first occurance of target is returned, -1 if not found
   */
  public static int binSearch(int[] a, int target, int l, int r){

    // Do not remove or modify the following line of code
    BIN_CALLS++;

    // check if left holds value (satisfies precondition)
    if (a[l] == target){
      return l;
    }

    // value not found, breaks loop and returns -1
    if (r == l){
      return -1;
    }

    // testing value, average value of l and r
    int mid = (l + r) / 2;

    // a[mid] is greater than target value, lowers right index to mid -1
    if (a[mid] > target){
      return binSearch(a, target, l, mid-1);

    // a[mid] is less than target value, raises left index to mid + 1
    } else if (a[mid] < target){
      return binSearch(a, target, mid+1, r);

    // a[mid] is equal to target value
    } else {
      return binSearch(a, target, l, mid); 
    }
  }
}

