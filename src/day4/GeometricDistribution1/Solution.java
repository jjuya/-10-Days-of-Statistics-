/*
 * The probability that a machine produces a defective product is 1/3. 
 * What is the probability that the 1st defect is found during the 5th inspection?
 */

package day4.GeometricDistribution1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int numerator = sc.nextInt();
    	int denominator = sc.nextInt();
    	int count = sc.nextInt();
    	
    	double p = (double)numerator / denominator;
    	
    	double result = 0.0;
    	
    	result = Math.pow((1 - p), count - 1) * p;
    	
    	System.out.printf("%.3f",result);
    	
    } //end maim
} //end class