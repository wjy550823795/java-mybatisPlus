package com.lianxi;

import java.math.BigDecimal;
import java.util.Arrays;

public class Test_7_31_2 {
	//279. 完全平方数
	public static void main(String[] args) {
		
//		System.out.println(numSquares(13));
		
//		int sqrt = (int)Math.sqrt(13);
//		System.out.println(sqrt);
		array = new int[12+1];
		Arrays.fill(array, -1);
		System.out.println(numSquares(12));
		
//		System.out.println(Arrays.toString(array));
	}
	
    private static int[] array;
	 
    public static int numSquares(int n) {
    	for (int i = 1; i<=n; i++) {
    		int minVal = 0;
			for ( int j = 1; j*j <= i ; j++ ) {
			  minVal = Math.min(minVal, array[i - j*j]);
			}	
			array[i] = minVal + 1;
		}
    	 return array[n];
    }
}
