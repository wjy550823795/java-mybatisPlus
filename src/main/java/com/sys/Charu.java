package com.sys;

import java.util.Arrays;

public class Charu {
	public static void main(String[] args) {
		long startime = System.currentTimeMillis();
		int num[]= {66,13,51,76,81,26,57,69,23};
		Cha(num);
		System.out.println(Arrays.toString(num));
		System.out.println("执行时间:"+(System.currentTimeMillis()-startime));
	}
	
   public  static void Cha(int[] num) {
		for (int i = 0; i < num.length-1; i++) {
			int current  = num[i+1];//后面的数
			int count = i;
			
			while (count>=0 && current<num[count]) {//
				num[count + 1] = num[count];
				count--;
			}
			
			System.out.println("i="+i+"时count为"+count);
			
			num[count+1] = current;
			System.out.println("i:"+i+"     "+Arrays.toString(num));
		}
	}
   
   public static void swap(int[]num,int l,int r) {
		int p = num[l];
		num[l] = num[r];
		num[r] = p;
	}
   
}
