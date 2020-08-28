package com.lianxi;

import java.util.Arrays;

public class Test_7_30_Charu {
	public static void main(String[] args) {
		int array[] = {66,13,51,76,81,26,57,69,23,99};
		
//		int[] charu = Charu(array);
//		System.out.println(Arrays.toString(charu) );
		
//		int[] xier = Xier(array);
//		System.out.println(Arrays.toString(xier));
		
		int[] xuanze = Xuanze(array);
		System.out.println(Arrays.toString(xuanze));
		
		
	}
	 public static int[] Xuanze(int[] array) {
		 for (int i = 0; i < array.length; i++) {
			int temp = i;
			for (int j = i; j < array.length; j++) {
				while(array[temp]>array[j]) {
					temp = j;
				}
			}
			swap(array, temp, i);
		 }
		 return array;
	 }
	 
	 public static void swap(int[]num,int l,int r) {
			int p = num[l];
			num[l] = num[r];
			num[r] = p;
		}
	 
	 public static int[] Charu(int[] array) {
		 for (int i = 0; i < array.length-1; i++) {
			 int temp = array[i+1];//后一位
			 int count = i;
			 while (count>=0&&temp<array[count]) {
				//当后一位小于前一位 向前移动
				 array[count+1] = array[count--];
				 System.out.println("count=:"+count+"  "+Arrays.toString(array));
			}
			 //false
			 array[count+1] = temp;
		}
		 return array;
	 }
	 
	 public static int[] Xier(int[] array) {
		 int flag = array.length/2;
		 while(flag>0) {
			 for (int i = flag; i < array.length; i++) { //i = 5
				 int temp = array[i];//temp  = array[5-5=0]
				 int count = i-flag;
				 while (count>=0 && temp<array[count]) {
					 array[count+flag] = array[count];
					 count = count-flag;
					 System.out.println("count=:"+count+"  "+Arrays.toString(array));
				}
				//false
				 array[count+flag] = temp;
			}
		 flag = flag/2;
		 }
		 return array;
	 }
}
