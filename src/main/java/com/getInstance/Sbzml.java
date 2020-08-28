package com.getInstance;

//饿汉式
public class Sbzml {
	
	private Sbzml() {};
	
	private static Sbzml sb = new Sbzml();

	public static Sbzml getInstance() {
		return sb;
	}
	
	
}
