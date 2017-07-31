package day0.MeanMedianAndMode;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    		
      	double mean = 0.0;
      	double median = 0.0;
      	long mode = 0;
    	
    	Scanner sc = new Scanner(System.in);
    	int num = sc.nextInt();
    	
    	int[] arr = new int[num];
    	
    	for(int i = 0; i < num; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	Arrays.sort(arr);
    	
    	mean = Double.parseDouble(String.format("%.1f", getMean(arr)));  
    	median = Double.parseDouble(String.format("%.1f", getMedian(arr)));  
    	mode = getMode(arr);
    	
    	System.out.println(mean);
    	System.out.println(median);
    	System.out.println(mode);
    } //end main
    
    
    private static long getMode(int[] arr) {
		long result = 0;
		int temp;
		int max = 0;
		int count = 0;		
		
		for(int i = 0; i < arr.length; i++) {
			temp = arr[i];
			count = 0;
			
			for(int j = 0; j < arr.length; j++) {
				if(temp == arr[j]) {
					count++;
				}
		         
				if(count > max) {  
					max = count;
		           
					if(max == 1) {
						result=arr[0];
					}
		            
					result = temp;
				}
			}
		}
		
		return result;
	}


	private static double getMedian(int[] arr) {
		
    	double result = 0.0;
    	int num = arr.length;
    	int mid = (num-1)/2;
    	
    	if((num%2) == 1) {
    		result = arr[mid];
    	} else {
    		result = (double)(arr[mid] + arr[mid + 1]) / 2 ;
    		
    	}
		
		return result;
	}


	private static double getMean(int[] arr) {
    	
    	int sum = 0;
    	double result = 0.0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		sum = sum + arr[i];
    	}
    	
    	result = (double)sum / arr.length;
    	
    	return result;
    }
    
} //end class