package com.leetcode;

public class Test_209 {
	public static void main(String[] args) {
		int nums[] = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,nums));
		
//		int array[] = {13, 23, 26, 51, 57, 66, 69, 76, 81};
//		System.out.println(array.length);
//		System.out.println(find2(0, array.length-1, array, 76));
		
	}
	
	public static int find2(int l,int r,int[] array,int k ) {
		int middle = (l+r)/2;
		if(k>array[r]||k<array[l]) {
			return -1;
		}
		
		if(k>array[middle]) {
			return find2(middle+1, r, array, k);
		}else if(k<array[middle]) {
			return find2(l, middle-1, array, k);
		}else {
			return middle;
		}
		
	}
	
	
	
	
     public static int minSubArrayLen(int s, int[] nums) {
    	  int l = 0;
    	  int r = -1;
    	  int sum = 0;
    	  int length = nums.length;
    	  try {
    		  while (l<nums.length) {
    	    		 if(r+1<nums.length&&sum<s) {
    	    			 r++; //先加
    	    			 sum+=nums[r];//先加右边界再sum
    	    		 }else {
    	    			 sum-=nums[l];//把左边界减了
    	    			 l++;//后加
    	    		 }
    		   if(sum>=s) {
	    		 System.out.println("r=:"+r+" l=:"+l);
    			 length = Math.min(length, r-l+1); 
    		   }
    				
		}} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
    	return length; 
     }
}
