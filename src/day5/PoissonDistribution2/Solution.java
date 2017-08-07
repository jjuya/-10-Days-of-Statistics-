/*
 * The manager of a industrial plant is planning to buy a machine of either type A or type B. 
 * For each day’s operation:
 * 
 * The number of repairs, X, that machine A needs is a Poisson random variable with mean 0.88. 
 * The daily cost of operating A is C = 160 + 40X^2.
 * 
 * The number of repairs, Y, that machine B needs is a Poisson random variable with mean 1.55. 
 * The daily cost of operating B is C = 128 + 40Y^2.
 * 
 * Assume that the repairs take a negligible amount of time and the machines are maintained nightly to ensure that they operate like new at the start of each day. 
 * Find and print the expected daily cost for each machine.
 * 
 * Input format
 * A single line comprised of 2 space-separated values denoting the respective means for A and B:
 * 
 * 	0.88 1.55
 * 	
 * Output format
 * 	On the first line, print the expected daily cost of machine A.
 *  On the second line, print the expected daily cost of machine B.
 */

package day5.PoissonDistribution2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	double A = sc.nextDouble();
    	double B = sc.nextDouble();
    	
    	//E[X^2] = lamda + lamda^2;
    	double dailyCostA = 160 + 40 *(A + (A * A));
    	double dailyCostB = 128 + 40 *(B + (B * B));
    	
    	System.out.printf("%.3f \n", dailyCostA);
    	System.out.printf("%.3f \n", dailyCostB);
        
    } //end main
} //end class