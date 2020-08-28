package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 求子集 {
	public static void main(String[] args) {
		int  nums[] = {1,2,3};
		List<List<Integer>> subsets = subsets(nums);
		System.out.println(subsets.toString());
		
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < nums.length; i++) {
			if(res.size()!=0) {
				int all = res.size();
				for (int j = 0; j < all; j++) {
					List<Integer> haha = new ArrayList<>(res.get(j));
					System.out.println(haha.toString());
					haha.add(nums[i]);
					res.add(haha);
				}
			}
			List<Integer> varlist = new ArrayList<>();
			varlist.add(nums[i]);
			res.add(varlist);
		}
		res.add(new ArrayList<>());
		return res;
    }
}
