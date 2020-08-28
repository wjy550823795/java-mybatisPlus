package com.sys;

import java.util.ArrayList;
import java.util.List;

public class Test_7_26_2 {
	
	static String[] Map = {
			" ",//0
			"",//1
			"abc",//2
			"def",//3
			"ghi",//4
			"jkl",//5
			"mno",//6
			"pqrs",//7
			"tuv",//8
			"wxyz"};//9
	static List<String> list = new ArrayList<String>();
	//letcode27.
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
	
	 public static List<String> letterCombinations(String digits) {
		 if(!digits.equals("")) {
			 digui(digits,0,"");
		 }
		
		 return list;
    }
	 
	 public  static void digui(String digits,int index,String res) {
		if(index ==digits.length()) {
			list.add(res);
			return;
		}
		char c = digits.charAt(index);//23
		String leetcode = Map[c-'0'];
		for (int i = 0; i < leetcode.length(); i++) {
			digui(digits,index+1,res+leetcode.charAt(i));
		}
     }
}
