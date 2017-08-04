/*
 * A manufacturer of metal pistons finds that, 
 * on average, 12% of the pistons they manufacture are rejected 
 * because they are incorrectly sized. 
 * What is the probability that a batch of 10 pistons will contain:
 * 
 * 1 .No more than 2 rejects?
 * 2. At least 2 rejects?
 * */

package day4.BinomialDistribution2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
		
	static long  factorial(int n) {
		if(n == 0)
			return 1;
		return n*factorial(n-1);
	}

	static double  combination(int r) {
		return (factorial(10)/(factorial(r) * factorial(10-r))); 
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		double p = sc.nextDouble() / 100;
		int count = sc.nextInt();
		
		double probability=0.0;
		
		for(int i = 0 ;i <= 2;i++) {
			probability = probability + combination(i)*Math.pow(p,i) * Math.pow(1 - p,count - i); 
		}
		System.out.printf("%.3f \n",probability);
		
		probability=0.0;
		
		for(int i = count ;i >= 2;i--) {
			probability +=  combination(i)*Math.pow(p,i) * Math.pow(1 - p, count -i); 
		}
		System.out.printf("%.3f",probability);
	} //end main
} //end class