package com.lianxi;

import java.util.Arrays;


public class Test_quick {
	public static void main(String[] args) {
//		int arr[] = {66,13,23,51,76,81,26,57,69,99,23};
		System.out.println(111);
//		int arr[] = {3,2,3,1,2,4,5,5,6};
		int arr1[] = {5, 1, 9, 7, 3};
		int[] quick = quick(arr1, 0, arr1.length-1);
//		try {
//			
//		} catch (Exception e) {
//			throw e;
//			// TODO: handle exception
//		}
		System.out.println(Arrays.toString(quick));
		
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
			while (l<r && key<arr[r]) {
				r--;
			}
			arr[l]=arr[r];
			System.out.println("r="+r+"时:  "+Arrays.toString(arr));
			while (l<r && key>arr[l]) {
				l++;
			}
			arr[r]=arr[l];
			System.out.println("l="+l+"时:  "+Arrays.toString(arr));
		}
		arr[l]=key;
		System.out.println("key="+key+"时:  "+Arrays.toString(arr));
		return l;
	}
	
	 public static int partition2(int[] arr, int left, int right) {
	        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
                System.out.println("i=:"+i+"  index=:"+index+"  arr[]:"+Arrays.toString(arr));
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
}
