package com.sys;

import java.util.Arrays;

public class Paixu {
	
	
	public static void main(String[] args) {
		int num[]= {66,13,51,76,81,26,57,69,23};
		Kuaisu(num, 0, num.length-1);
		System.out.println(Arrays.toString(Xuanze(num)));
//		Arrays.sort(num);
		
//		System.out.println(Arrays.toString(Maopao(num)));
//		int nums[]= {13, 23, 26, 51, 57, 66, 69, 76, 81};
//		System.out.println(Findtwo(nums, 0, nums.length-1, 23));
	}
	
	//选择排序
	 public static int[] Xuanze(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            swap(array, i,minIndex);
        }
        return array;
    }
	 
	
	 //快速
	static void Kuaisu(int[] num,int left,int right) {
		if(left<right) {
			int p = position(num, left, right);
			Kuaisu(num, left, p-1);
			Kuaisu(num, p+1, right);
		}
	}
	
	static int position(int[] num,int l,int r) {
		int key = num[l];
		while (l<r) {
			while (l<r && key<=num[r]) {
				
					--r;
				
			}
			num[l]=num[r];
			while (l<r && key>=num[l]) {
				
					++l;
				
			}
			num[r]= num[l];
		}
		num[l] = key;
		return l;
	}
	
	//冒泡
//	static int[] Maopao(int[] num) {
//			for (int i = 0; i < num.length; i++) {
//				for (int j = 0; j < num.length-1-i; j++) {
//					if(num[j]>num[j+1]) {
//						swap(num, j, j+1);
//					}
//				}
//			}
//		return num;
//	}
	
//	static boolean Findtwo(int[] num,int left,int right,int k) {
//		int middle= (left+right)/2;
//		if(k>num[right]||k<num[left]||left>right) {
//			return false;
//		}
//		if(k>num[middle]) { //右边
//			return FindTwo(num, middle+1, right, k);
//		}else if(k<num[middle]) {//左边
//			return FindTwo(num, left, middle-1, k);
//		}else {
//			return true;
//		}
//		
//	}
	
	public static void swap(int[]num,int l,int r) {
		int p = num[l];
		num[l] = num[r];
		num[r] = p;
	}
}
