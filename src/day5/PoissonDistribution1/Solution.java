/*
 * A random variable, X, follows Poisson distribution with mean of 2.5.
 * Find the probability with which the random variable X is equal to 5.
 * 
 * Input format
 * The first line contains X's mean. 
 * The second line contains the value we want the probability for:
 * 2.5
 * 5
 */

package day5.PoissonDistribution1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double lambda = sc.nextDouble();
		int k = sc.nextInt();

		System.out.printf("%.3f", poisson(k, lambda));
	} //end main

	static double poisson(int k, double lambda) {
		return (Math.pow(lambda, k) * Math.pow(Math.E, -1 * lambda)) / factorial(k);
	}


	static long factorial(int n) {
		if(n == 0)
			return 1;
		return n * factorial(n-1);
	}

} //end class