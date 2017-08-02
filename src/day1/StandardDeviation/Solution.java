package day1.StandardDeviation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}		
		
		double sDeviation = getStandardDeviation(arr);
		
		System.out.println(sDeviation);
		
		
	} //end main
	
	private static double getMean(int[] arr) {
    	
    	int sum = 0;
    	double result = 0.0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		sum = sum + arr[i];
    	}
    	
    	result = (double)sum / arr.length;
    	
    	return result;
    }
	
	private static double getStandardDeviation(int[] arr) {
    	
    	double sum = 0.0;
    	double mean = getMean(arr);
    	double result = 0.0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		sum = sum + Math.pow((mean - arr[i]), 2);
    	}
    	
    	result = Math.sqrt(sum / arr.length);
    	
    	return result;
    }
} //end class