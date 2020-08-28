package com.leetcode;

import java.util.Arrays;

public class Test_215 {
	
		public static void main(String[] args) {
			int[] nums = {3,2,3,1,2,4,5,5,6};
			findKthLargest(nums, 0,nums.length-1);
			System.out.println(Arrays.toString(nums));
			
//			int[] b = {3,2,3,1,2,4,5,5,6};
//			Arrays.sort(b);
//			System.out.print(Arrays.toString(b));
		
		}
		
		public static void findKthLargest(int[] nums,int l,int r) {
			if(l<r) {
				int pivot = pivot(nums, l, r);
				findKthLargest(nums, l, pivot-1);
				findKthLargest(nums, pivot+1, r);
			}
//			if(k<pivot) {
//				return pivot(nums, 0, pivot-1);
//			}else if(k>pivot){
//				return pivot(nums, pivot, nums.length-1);
//			}else {
//				return pivot+1;
//			}
	    }
		
		public static int pivot(int[] nums,int l,int r) {//获取支点
			int key = nums[l];//key
			while (l<r) {
				while (l<r&&key<=nums[r]) {
					r--;
				}
				nums[l] = nums[r];
				while (l<r&&key>=nums[l]) {
					l++;
					
				}
				nums[r] = nums[l];
			}
			nums[l] = key;
			System.out.println(Arrays.toString(nums));
			return l;
	  }
		
}
