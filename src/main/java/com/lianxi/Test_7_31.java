package com.lianxi;

import java.util.Arrays;

//letcode343整数拆分求最大乘积
public class Test_7_31 {
	public static void main(String[] args) {
		
		array = new int[11+1];
		Arrays.fill(array, -1);
//		
//		System.out.println("乘积为:"+integerBreak(11));
//		
//		System.out.println("记忆化:"+Arrays.toString(array));
		
//		System.out.println(Tanxin(11));
		
		System.out.println("动态规划:"+Dongtaiguihua(11));
		
	}
	
	 private static int[] array;
	 
	 //动态规划解法
	 public static int Dongtaiguihua(int n) {
		 
		 array[1] = 1;
		 for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				int k = i-j;
				array[i] = Maxmax(array[i], j*k,j*array[k]);
				System.out.println("j=:"+j+"  k=:"+k+"   array["+i+"]:"+array[i]);
			}
		}
		return array[n]; 
	 }
	 
	 
	 
	 //贪心算法
	 public static int Tanxin(int n) {
		 if(n == 2)
		        return 1;
		    if(n == 3)
		        return 2;
		    int a = 1;
		    while(n > 4){
		        n = n - 3;
		        a = a * 3;
		    }
		    return a * n;
	 }
	 
	 public static int integerBreak(int n) {
	 	if(n==1) {
	 		return 1;
	 	}
	 	
	 	if(array[n]!=-1) {
	 		return array[n];
	 	}
	 	
	 	int temp = -1;
	 	for (int i = 1; i < n ; i++) {
			int k = n-i;
			int cheng = i*integerBreak(k);
			temp  = Maxmax(temp, i*k, cheng);
			System.out.println("i=:"+i+" i*k=:"+i*k+"  cheng=:"+cheng);
		}
	 	array[n] = temp;
	 	return temp;
    }
	 
	 
	 public static int Maxmax(int a,int b,int c) {
		 return Math.max(a, Math.max(b, c));
	 }
}
