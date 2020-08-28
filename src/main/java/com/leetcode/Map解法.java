package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map解法 {
	
		public static void main(String[] args) {
			int a[] = {1,6,5,2,7,9,3};
//			Arrays.sort(a);
//			System.out.println("排序:"+Arrays.toString(a));
			
//			List<List<Integer>> sumeight = sumeight(a, 8);
//			System.out.println("结果res:"+sumeight.toString());
			
			System.out.println(twoSum(a,8).toString());
			
		}
		
		public static List<List<Integer>> twoSum(int[] nums, int target) {
			List<List<Integer> > arrayList = new ArrayList<>();
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            int complement = target - nums[i];//算差值 当i=0 nums[i]==1 complement=8-1 =7
	            if (map.containsKey(complement)) {//map里是否有7
	            	List<Integer> arrayList2 = new ArrayList<>();
					arrayList2.add(nums[i]);
					arrayList2.add(complement);
					arrayList.add(arrayList2);
	            }
	            map.put(nums[i], i);//不管有没有都set
	        }
	        return arrayList;
	    }


		
		 public static List<List<Integer>> sumeight(int[] a,int k) {
			 List<List<Integer> > arrayList = new ArrayList<>();
			 int l = 0; int r = a.length-1;
			
			 while (l<r) {
				 int sum = a[l]+a[r];
				 System.out.println("sum = "+sum);
				 if(sum>k) {
					 r--;
				 }else if(sum<k) {
					 l++;
				 }else {
					 List<Integer> arrayList2 = new ArrayList<>();
						 arrayList2.add(a[l]);
						 arrayList2.add(a[r]);
						 arrayList.add(arrayList2);
					 r--;
					 l++;
				 }
			}
			 return arrayList;
		 }
}
