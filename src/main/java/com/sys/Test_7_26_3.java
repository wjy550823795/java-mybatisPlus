package com.sys;

import java.util.ArrayList;
import java.util.List;
public class Test_7_26_3 {
	
	
		static List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		//letcode46.
		public static void main(String[] args) {
			int num[] = {1,2,3};
			System.out.println(permute(num));
		}
		
	    public static List<List<Integer>> permute(int[] nums) {
	    	if(nums.length!=0) {
	    		digui(nums,new ArrayList<>());
	    	}
	    	
	    	return list;
	    }
	    
	    public static void digui(int[] nums,List<Integer> res) {
	    	if(res.size() == nums.length) {
	    		list.add(new ArrayList<>(res));
	    		return;
	    	}
	    	for (int i = 0; i < nums.length; i++) {
				if(!res.contains(nums[i])) {
					res.add(nums[i]);
					digui(nums,res);
					res.remove(res.size()-1);
				}
				System.out.println("list.szie:"+list.size()+"~~~~~~~"+"res子数组为:"+res.toString());
			}
	    	return;
	    }
		
}
