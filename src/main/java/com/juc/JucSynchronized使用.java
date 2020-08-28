package com.juc;


public class JucSynchronized使用 {
	public static void main(String[] args) {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		baba baba = new baba();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				baba.add();
			}
			
		},"A").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				baba.sub();
			}
		},"B").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				baba.add();
			}
			
		},"C").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				baba.sub();
			}
		},"D").start();
		
	}
	
	
	static  class baba{
		private  int temp = 0;
		synchronized void add()  {
			while (temp!=0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			temp++;
			notifyAll();
			System.out.println(Thread.currentThread().getName()+"==>"+temp+":我执行了add");
		}
		
		synchronized void sub()  {
//			if(temp!=1) {
			while (temp!=1) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			temp--;
			notifyAll();
			System.out.println(Thread.currentThread().getName()+"==>"+temp+":我执行了sub");
		}
		
	}
}
