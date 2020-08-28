package com.leetcode;

import java.util.Arrays;

public class 奇偶排序 {
	public static void main(String[] args) {
		int a[] = {3,4,7,9,1,5,2}; 
		int[] jiou = jiou(a);
		System.out.println(Arrays.toString(jiou));
	}
	
	
	public static int[] jiou(int[] a) {
		int res[] = new int[a.length];
		int l = 0;
		int r = a.length-1;
		int count = 0;
		while (l<=r) {
			if(a[count]%2==0) {
				res[l++] = a[count++];
			}else {
				res[r--] = a[count++];
			}
		}
		System.out.println(Arrays.toString(res));
		System.out.println("l:"+(l));
		quick(res, 0, l-1);
		quick(res, l, a.length-1);
		return res;
	}
	
	public static int[] quick(int arr[],int l,int r) {
		if (l < r) {
	        int partitionIndex = partition1(arr, l, r);
//	        int partitionIndex = partition2(arr, l, r);
	        quick(arr, l, partitionIndex - 1);
	        quick(arr, partitionIndex + 1, r);
        }
			return arr;
	}
	
	public static int partition1(int arr[],int l,int r) {
		int key = arr[l];
		while (l<r) {
			while (l<r && key<=arr[r]) {
				r--;
			}
			arr[l]=arr[r];
			while (l<r && key>=arr[l]) {
				l++;
			}
			arr[r]=arr[l];
		}
		arr[l]=key;
		System.out.println("key="+key+"时:  "+Arrays.toString(arr));
		return l;
	}
}
