package com.sys;

import java.util.Arrays;

public class Test_7_26_1 {
	
	
	public static void main(String[] args) {
		int num[]= {66,13,51,76,81,26,57,69,23};
//		Quicksort(num);
		qSort(num,0,num.length-1);
		 
	}
	
	 static void qSort(int[] arr,int s,int e){
		 System.out.println(Arrays.toString(arr));
	        int l = s, r = e;
	        if(l < r){
	            int temp = arr[l];
	            while(l < r){
	                while(l < r && arr[r] >= temp) r--;
	                if(l < r) arr[l] = arr[r];
	                while(l < r && arr[l] < temp) l++;
	                if(l < r) arr[r] = arr[l];
	            }
	            arr[l] = temp;
	            qSort(arr,s,l);
	            qSort(arr,l + 1, e);
	        }
	    }
	
	public static void Quicksort(int[]num) {
		int left =  0;
 		int right = num.length-1;
 		int temp = num[left];
		while (left<right) {
			System.out.println("num[]left:"+num[left]);
			System.out.println("num[]right:"+num[right]);
			if(temp>num[right]) {
				swap(num,left,right);
				left++;
			}else {
				right--;
			}
		}
		System.out.println(Arrays.toString(num));
	}
	public static void swap(int[]num,int l,int r) {
		int p = num[l];
		num[l] = num[r];
		num[r] = p;
	}
}
