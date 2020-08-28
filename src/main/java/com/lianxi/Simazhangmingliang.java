package com.lianxi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Simazhangmingliang {
	public static void main(String[] args) {
		Integer a[]= {66,13,51,76,81,26,57,69,23};
		Arrays.sort(a, (o1,o2)->{
			return o2-o1;
			}
		);
		System.out.println(Arrays.toString(a));
		
	}
//	public static void main(String[] args) {
//		  int[] numarry = new int[]{1,2,3,2,3};
//	        int aim = numarry[0];
//	        for(int i = 1; i < 5; i++)
//	        {
//	        	System.out.print(aim+"^"+numarry[i]+"= ");
//	            aim = aim ^ numarry[i];
//	            System.out.print(aim);
//	            System.out.println();
//	        }
//	        System.out.println("最后："+aim);
//	        
//	        System.out.println(0^3);
//	}
}
