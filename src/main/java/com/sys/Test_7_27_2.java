package com.sys;
import java.util.ArrayList;
import java.util.List;

public class Test_7_27_2 {
	
	
	//leetcode120三角形最小路径和
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{add(2);}});
		list.add(new ArrayList<Integer>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{ add(3);add(4);}});
		list.add(new ArrayList<Integer>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{ add(6);add(5);add(7);}});
		list.add(new ArrayList<Integer>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{ add(4);add(1);add(8);add(3);}});
		System.out.println(list.toString());
		System.out.println(minimumTotal2(list));
		
	}
	//错误解法
//	 public static int minimumTotal(List<List<Integer>> triangle) {
//		int m = 0;
//		int res = 0;
//		for (int i = 0; i < triangle.size(); i++) {
//			if(i==0) {
//				res+=triangle.get(m).get(m);
//				continue;
//			}
//			Integer  left = triangle.get(i).get(m);
//			Integer  right = triangle.get(i).get(m+1);
//			if(left>right) {
//				res+=right;
//				m=m+1;
//			}else {
//				res+=left;
//			}
//		}
//		return res;
//	 }
	 //正确解法
	 public static int minimumTotal2(List<List<Integer>> triangle) {
		 int index = triangle.size()-1;
		 List<Integer> list = triangle.get(index);//4 1 8 3 //7,
		 for (int i = index-1; i >=0; i--){
			for (int j = 0; j <= i; j++) {
				int k = triangle.get(i).get(j);//定值j=0 k =6, j =1 k =5
				System.out.println(list.toString());
				int left = list.get(j);//4,
				int right = list.get(j+1);//1,
//				if(left<right) {
//					list.set(j, k+left);
//				}else {
//					list.set(j, k+right);//7
//				}
				list.set(j, Math.min(k+left,k+right));
			}
		}
		 return list.get(0);
	 }
}
