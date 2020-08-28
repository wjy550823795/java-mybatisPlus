package com.sys;

import java.util.Collections;
import java.util.Vector;

public class Test_7_27_3 {
	public static void main(String[] args) {
		int num [] = {3,5,9,11,14,15};
		boolean getk = getk(num, 33);
		System.out.println(getk);
	}
	
	public  static boolean getk(int[] num,int k) {
		Vector<Integer> a = new Vector<>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				System.out.println("num[i]:"+num[i]+",num[j]"+num[j]);
				a.add(num[i]+num[j]);
			}
		}
		Collections.sort(a);
		System.out.println(a.toString());
		int size = a.size()-1;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				if(find(a,0,size--,k-num[i]-num[j])) {
					System.out.println("num[i]:"+num[i]+",num[j]"+num[j]);
					return true;
				}
			}
		}
		
		return false;
	}
	public  static boolean find(Vector<Integer> num,int l,int r,int res) {
		int zhongjian = (l+r)/2;
		if(res>num.get(r) || res<num.get(l) || l>r) {
			return false;
		}
		if(res>num.get(zhongjian)) {
			return find(num, zhongjian+1, r, res);
		}
		else if(res<num.get(zhongjian)) {
			return find(num, l, zhongjian-1, res);
		}else {
			return true;
		}
		
	}
	
}
