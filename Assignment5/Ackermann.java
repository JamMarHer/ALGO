/*
  Name: Bastien Gliech
  CIS 303 Algorithm Analysis and Design
  Assignment: 4 - BinSearch
  Due: February 27, 2018
*/

import java.util.*;

/////////////////////////////////////////////////////////////////////////
// The ackermann class is an executable java file that runs the Ackermann
// function utilizing a stack object and recursion on a time test.
//
// Algorithm: A(m, n) = 
// n + 1 if m = 0
// A(m - 1, 1) if n = 0 && m > 0
// A(m - 1, A(m, n - 1)) if n, m > 0
// 
public class Ackermann {
  
  // main method
  //
  // @param: String[] args -- arguments for the algorithm
  //                          1. args[0] = m value
  //                          2. args[1] = n value
  // @pre: m and n are greater than 0
  // @post: none
  public static void main(String[] args){

    // inputs: m and n
    long m = Long.parseLong(args[0]);
    long n = Long.parseLong(args[1]);

    // temp variables
    long stop, start, nfinal;

    // Recursive ackermann call
    System.out.println("Recursive:");
    start = System.currentTimeMillis(); // start time
    nfinal = ackermannRecursion(m, n);
    stop = System.currentTimeMillis(); // stop time
    stop -= start; // final time

    // prints recursive results
    System.out.println("n = " + nfinal + "  time: " + stop + "ms");

    // Stack ackermann call
    System.out.println("Stack:");
    start = System.currentTimeMillis(); // start time
    nfinal = ackermannStack(m, n);
    stop = System.currentTimeMillis(); // stop time
    stop -= start; // final time

    // prints stack results
    System.out.println("n = " + nfinal + "  time: " + stop + "ms");
  }

  // Recursive Implementation (Found online)
  //
  // @param: 1. long m = m value
  //         2. long n = n value
  // @pre: m and n are greater than 0
  // @post: final n value is returned
  public static long ackermannRecursion(long m, long n){
    if (m == 0) return n + 1;
    if (n == 0) return ackermannRecursion(m - 1, 1);
    return ackermannRecursion(m - 1, ackermannRecursion(m, n - 1));
  }

  // Stack Implementation
  //
  // @param: 1. long m = m value
  //         2. long n = n value
  // @pre: m and n are greater than 0
  // @post: final n value is returned
  public static long ackermannStack(long m, long n){

    // creates stack for m values
    Stack<Long> mstack = new Stack<Long>();

    // pushes initial m value to stack
    mstack.push(m);

    // while stack still has values of m
    while (!mstack.empty()){

      // sets m to last m in stack
      m = mstack.pop();

      // increments n
      if (m == 0){
        n++;

      // pushes m - 1, increments n
      } else if (n == 0 && m > 0){
        mstack.push(m - 1);
        n++;

      // pushes m - 1 and m, decrements n
      } else {
        mstack.push(m - 1);
        mstack.push(m);
        n--;
      }
    }

    // returns final n
    return n;
  }
}