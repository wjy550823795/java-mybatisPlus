package com;

import java.util.HashMap;
public class HashMapTest {
	public static void main(String[] args) {
		String str1 = "通话";
		String str2 = "重地";
		System.out.println(str1.equals(str2));
		
		HashMap<String, Object> map = new HashMap<>();
			map.put("1", str1);
			System.out.println("str1:"+str1.hashCode());
			map.put("2", str2);
			System.out.println("str2:"+str2.hashCode());
			
			
			
			
	}
}
