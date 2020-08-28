package com.sys;
import java.util.Arrays;

import lombok.extern.java.Log;

@Log
public class Test_7_27_1 {
	
	
	   private static int[] memo;
	   static int num = 0;
	    //斐波那契数列 青蛙跳台问题
		public static void main(String[] args) {
			long startTime = System.currentTimeMillis();
			memo = new int[20+1];
			Arrays.fill(memo, -1);
//			System.out.println(fuc(20));
			System.out.println(f(20));
			long endTime = System.currentTimeMillis();
			log.info("运行时间为：" + (endTime - startTime) + "ms");		
			log.info("f(n)执行：" + num);	
			
//			log.info("fnc(n)执行：" + num);		
		}
		//最优解 执行n-2次 20-2 = 18
	    public static int fuc(int n) {
	    	memo[1] = 1;
	    	memo[2] = 2;
	    	for (int i = 3; i <= n; i++) {
	    		num++;
	    		memo[i] = (memo[i - 1] + memo[i - 2]);
			}
	    	return memo[n];
	    }
	    //执行 (n-2)*2+1  20-2 = 18*2 = 36+1 =37
	    public static int f(int n) {
	    		num++;
	    	    if(n == 1)return 1 ;
	            if(n==2) return  2;
		        if(memo[n]==-1) {
		        	memo[n] =   (f(n - 1) + f(n - 2))%1000_000_007;
		        }
		       return memo[n]; 
		       
	    }
}
