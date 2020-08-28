package com.leetcode;

import java.util.Arrays;

public class 窗口滑动 {
	
	//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	public static void main(String[] args) {
		String s = "abcabcbbcdff";
		System.out.println(s.length());
		System.out.println(lengthOfLongestSubstring(s));
	}
	

	public static int lengthOfLongestSubstring(String s) {
		int left = 0;
		int right = -1;
		int length = 0;
		int shuzu[] = new int[126]; 
		try {
			while (left<s.length()) {
				
				if(right+1<s.length() && shuzu[s.charAt(right+1)]==0) {
					//一开始创建的数组是空的 只有默认值0 长度限定了,数组的ASCII码
					//由于right的初始值为-1 所以要+1 -1+1=0 也就是第0位 取出来是a
					//小写a的ASCII码是97 所以当他等于0代表不存在 这时候右指针向右移动一位 且记录
					//shuzu[97]的值为1 当他再次判断到小写a时说明已存在 else
					right++;
					shuzu[s.charAt(right)]++;
				}else {
					//走else的时候说明已经要重新set length的长度了
//跟已有长度比较窗口最右端-窗口最左端再加一,[0,0]其实是有元素的 左闭右闭 所以是0+1=1
					length =  Math.max(length, right-left+1);
					
					//左边界的值从shuzu中减去 从1-->0
					shuzu[s.charAt(left)]--;
					//左边界++就跟左边界没关系了,拜拜了
					left++;
				}
				
				System.out.println(Arrays.toString(shuzu));
				
			} 
		}catch (Exception e) {
			throw e;
		}
			// TODO: handle exception
		
		return length;	
	}
}
