package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JucLock锁使用 {
	
	
	
	
			
	public static void main(String[] args) {
		
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
		Lock lock = new ReentrantLock();
		Condition cond = lock.newCondition();
		
		private  int temp = 0;
		 void add()  {
			 lock.lock();
			 try {
				 while (temp!=0) {
					 cond.await();
					}
					temp++;
					cond.signalAll();
					System.out.println(Thread.currentThread().getName()+"==>"+temp+":我执行了add");
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock.unlock();
			}
		}
		
		 void sub()  {
			 lock.lock();
			 try {
				 while (temp!=1) {
					 cond.await();
					}
					temp--;
					cond.signalAll();
					System.out.println(Thread.currentThread().getName()+"==>"+temp+":我执行了sub");
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock.unlock();
			}
		}
	}
}
