package com.getInstance;

//懒汉式
public class Smzml2 {
	
	private  Smzml2() {};
	
	
	private static Smzml2 sb = null;
	
//	public Smzml2() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public static Smzml2 getinstance() {
		if(sb==null) {
			sb = new Smzml2();
		}
		return sb;
	}
	
}
