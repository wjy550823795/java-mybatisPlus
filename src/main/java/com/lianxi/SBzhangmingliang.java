package com.lianxi;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;


public class SBzhangmingliang implements Runnable{
	public static void main(String[] args) {
//		String str1 = "通话";
//		String str2 = "重地";
//		System.out.println("str1:"+str1.hashCode());
//		System.out.println("str2:"+str2.hashCode());
//		System.out.println(str1.equals(str2));
		
//		long round = Math.round(-1.5);
//		long round2 = Math.round(1.5); 
//		System.out.println("round:"+round);
//		System.out.println("round2:"+round2);
//		new Stack<>();
		SBzhangmingliang sb = new SBzhangmingliang();
		for (int i = 0; i < 2; i++) {
	           new Thread(sb, i+"线程").start();
	       }
	}

	@Override
	public void run() {
		 for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"我是"+i);
		}
		
	}
	
	
}
