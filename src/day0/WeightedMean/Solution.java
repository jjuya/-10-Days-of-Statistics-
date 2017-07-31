package day0.WeightedMean;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    		
    	double result = 0.0;
    	
    	int sum = 0;
    	int wSum = 0;
    	
    	Scanner sc = new Scanner(System.in);
    	int num = sc.nextInt();
    	
    	int[] arr = new int[num];
    	int[] weight = new int[num];
    	
    	for(int i = 0; i < num; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	for(int i = 0; i < num; i++) {
    		weight[i] = sc.nextInt();
    	}
    	
    	for(int i = 0; i < num; i++) {
    		sum = sum + (arr[i] * weight[i]);
    		wSum = wSum + weight[i];
    	}
    	
    	result = (double)sum / wSum;
    	 
    	System.out.println(Double.parseDouble(String.format("%.1f", result)));
    
    	
    	
    } //end main
    
} //end class