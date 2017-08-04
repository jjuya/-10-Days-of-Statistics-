/*
 * The ratio of boys to girls for babies born in Russia is 1.09:1. 
 * If there is 1 child born per birth, 
 * what proportion of Russian families with exactly 6 children will have at least 3 boys?
 * Write a program to compute the answer using the above parameters. 
 * Then print your result, rounded to a scale of 3 decimal places (i.e., 1.234 format).
 * */

package day4.BinomialDistribution1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static long factorial(int n) {
		if(n == 0)
			return 1;
		return n * factorial(n-1);
	}

	static double combination(int r) {
		return (factorial(6) / (factorial(r) * factorial(6-r))); 
	}
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		double BOY= sc.nextDouble();
		double GIRL= sc.nextDouble(); 
		
		double p= (BOY)/(BOY+GIRL);
		double q=1-p;

		double probability=0.0;
		for(int i = 6 ;i >= 3;i--) {
			probability +=  combination(i)*Math.pow(p,i) * Math.pow(q,6-i); 
		}
		System.out.printf("%.3f",probability);
	} //end main
} //end class