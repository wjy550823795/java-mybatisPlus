package com.lianxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Caonimazhangming3 {
	
//	public static void main(String[] args) {
////		List<Object> arrayList = new ArrayList<>();
////		arrayList.add(1);
////		arrayList.add(2);
////		arrayList.add(3);
////		Collections.swap(arrayList,0, 2);
////		System.out.println(arrayList.toString());
//		
	
			
//		for (String key : map.keySet()) {
//			System.out.println(key+":"+map.get(key));
//		}
//	}
	
//	public static void main(String[] args) {
//		ArrayList<Object> arrayList = new ArrayList<>();
//		for (int i = 0; i < 11; i++) {
//			if(i==10) {
//				System.out.println("123");
//			}
//			arrayList.add("shabi");
//		}
//		LinkedList<Object> list = new LinkedList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		Object object = list.get(2);
//		System.out.println(object);
		
//	}
	
//	public static void main(String[] args) {
//		int[] myArray = { 1, 2, 3 };
//		List<int[]> myList = Arrays.asList(myArray);
//		System.out.println(myList.size());//1
//		System.out.println(myList.get(0));//数组地址值
//		System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
//		int [] array=(int[]) myList.get(0);
//		System.out.println(array[0]);//1
//	}
	
//	public static void main(String[] args) {
//		List<Integer> myList = Arrays.asList(1, 2, 3);
//		myList.add(4);//运行时报错：UnsupportedOperationException
//		myList.remove(1);//运行时报错：UnsupportedOperationException
//		myList.clear();//运行时报错：UnsupportedOperationException
//
//	}
	
	public static void main(String[] args) {
		String a[] =  new String[] {"123","456"};
		List<String> list = Arrays.asList(a);
		a[0] = "adhasiuhdoasd";
		System.out.println(list.toString());
		Object[] array = list.toArray();
		System.out.println(Arrays.toString(array));
	}
}
