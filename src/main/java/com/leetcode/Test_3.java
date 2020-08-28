package com.leetcode;


//leetcode窗口滑动
public class Test_3 {
	public static void main(String[] args) {
		String s = "abcabcbbcdff";
		System.out.println(s.length());
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
	  int l = 0;
  	  int r = -1;
  	  int length = 0;
  	  int[] charArray = new int[126];
  	  try {
  		  while (l<s.length()) {
  	    		 if(r+1<s.length()&& charArray[s.charAt(r+1)]==0) {
  	    			 r++; //先加
  	    			 charArray[s.charAt(r)]++; 
  	    		 }else {
  	    			 System.out.println(charArray[s.charAt(r)]);
  	    			 charArray[s.charAt(l)]--; 
  	    			 l++;//后加
  	    		 }
  	    		 
    			 length = Math.max(length, r-l+1); 
  				
		}} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
  	  return length; 
    }
}
