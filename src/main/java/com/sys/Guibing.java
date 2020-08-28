package com.sys;

import java.util.Arrays;

public class Guibing {
	public static void main(String[] args) {
		long startime = System.currentTimeMillis();
		int arr[]= {66,13,51,76,81,26,57,69,23};
		int[] is = MergeSort(arr);
		System.out.println(Arrays.toString(is));
		System.out.println("执行时间:"+(System.currentTimeMillis()-startime));
		
	}
	
	public static int[] MergeSort(int[] arr) {
		if (arr.length < 2) return arr;
		int a = arr.length/2;
		int[] left = Arrays.copyOfRange(arr, 0, a);
		System.out.println(Arrays.toString(left));
		
		int[] right = Arrays.copyOfRange(arr, a, arr.length);
		System.out.println(Arrays.toString(right));
		
		return merge(MergeSort(left), MergeSort(right));
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] arr = new int[left.length+right.length];
		int p = 0;//左边界
		int q = 0;//右边界
		int count = 0;
		while (p<left.length || q<right.length) {
			
			if(p<left.length && q<right.length && left[p]<right[q]) {
				arr[count++] = left[p++]; 
			}else if(p<left.length && q<right.length && left[p]>right[q]){
				arr[count++] = right[q++]; 
			}else if(p==left.length){
				arr[count++] = right[q++];
			}else {
				arr[count++] = left[p++];
			}
		}
		return arr;
	}
}
