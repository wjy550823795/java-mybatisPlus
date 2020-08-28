package com.sys;

import java.util.Arrays;
import java.util.Random;

public class Xier {
	public static void main(String[] args) {
//		Random rand = new Random(); //随机数   假设1-60
//		Integer bbb= rand.nextInt(10)+1;
//		System.out.println(bbb);
		int array[]= {66,13,51,76,81,26,57,69,23};
		int[] sort = ShellSort(array);
		System.out.println(Arrays.toString(sort));
	}
	
	public static int[] ShellSort(int[] array) {
		int len = array.length;
		int gap = len/2;
		 while (gap > 0) {
			for (int i = gap; i < len; i++) {
				 int temp = array[i];
				 int left = i-gap;
				 while (left>=0 && temp<array[left]) {//
					array[left + gap] = array[left];
					left = left-gap;
					System.out.println("i=:"+i+" left:"+left+"  "+Arrays.toString(array));
				 }
				 array[left+gap] = temp;
			}
			gap=gap/2;
		 }
		
		return array;
	}
	
	public static void swap(int[]num,int l,int r) {
		int p = num[l];
		num[l] = num[r];
		num[r] = p;
	}
	
	 public  static void Cha(int[] num) {
		for (int i = 0; i < num.length-1; i++) {
			int current  = num[i+1];//后面的数
			int count = i;
			
			while (count>=0 && current<num[count]) {//
				num[count + 1] = num[count];
				count--;
			}
			num[count+1] = current;
		}
	}
}
