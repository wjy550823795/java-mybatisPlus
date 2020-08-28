package com.lianxi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SBzhangmingliang2 implements Callable<Integer>{

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SBzhangmingliang2 sb = new SBzhangmingliang2();
	   FutureTask<Integer> ft = new FutureTask<>(sb);
	   for (int i = 0; i < 2; i++) {
//           System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
    	   new Thread(ft, "线程"+i).start();
       }
	   System.out.println("子线程的返回值：" + ft.get());
	}
	
	@Override
	public Integer call() throws Exception {
		int i=0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"我是"+i);
		}
		return i;
	}

}
