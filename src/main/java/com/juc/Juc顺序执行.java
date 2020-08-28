package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Juc顺序执行 {
	public static void main(String[] args) {
		baba baba = new baba();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				baba.printA();
			}
		},"A").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				baba.printB();
			}
		},"B").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				baba.printC();
			}
		},"C").start();
		
	}

	static  class baba{
		Lock lock = new ReentrantLock();
		Condition condA = lock.newCondition();
		Condition condB = lock.newCondition();
		Condition condC = lock.newCondition();
		int temp = 1;
			void printA()  {
				lock.lock();
				try {
					//业务、判断、执行-->通知
					while(temp!=1) {
						//等待
						condA.await();
					}
					System.out.println(Thread.currentThread().getName()+"==>AAAAAAAA");
					temp=2;
					condB.signal();
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					lock.unlock();
				}
			}
			void printB()  {
				lock.lock();
				try {
					//业务、判断、执行-->通知
					while(temp!=2) {
						//等待
						condB.await();
					}
					System.out.println(Thread.currentThread().getName()+"==>BBBBBBBB");
					temp=3;
					condC.signal();
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					lock.unlock();
				}
			}
			void printC()  {
				lock.lock();
				try {
					//业务、判断、执行-->通知
					while(temp!=3) {
						//等待
						condC.await();
					}
					System.out.println(Thread.currentThread().getName()+"==>CCCCCCCC");
					temp=1;
					condA.signal();
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					lock.unlock();
				}
			}
		}
}