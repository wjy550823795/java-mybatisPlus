package com;

public class ThreadpoolTest {
	
	public static final int SIZE = 32;
	
	public static void main(String[] args) {
		
		 int COUNT_BITS = Integer.SIZE - 3; //32-3
		 System.out.println("COUNT_BITS:"+COUNT_BITS);
		 
		 int CAPACITY = (1 << COUNT_BITS) - 1; //将 1 的二进制向右位移 29 位,再减 1 表示最大线程容量
		 System.out.println("CAPACITY:"+CAPACITY);
		 
		//运行状态保存在 int 值的高 3 位 (所有数值左移 29 位)
		 int RUNNING = -1 << COUNT_BITS;// 接收新任务,并执行队列中的任务
		 System.out.println("RUNNING=-1左移29位:"+RUNNING);
		 
		 int SHUTDOWN = 0 << COUNT_BITS;// 不接收新任务,但是执行队列中的任务
		 System.out.println("SHUTDOWN=0左移29位:"+SHUTDOWN);
		 
		 int STOP = 1 << COUNT_BITS;// 不接收新任务,不执行队列中的任务,中断正在执行中的任务
		 System.out.println("STOP=1左移29位:"+STOP);
		 
		 int TIDYING = 2 << COUNT_BITS; //所有的任务都已结束,线程数量为 0,处于该状态的线程池即将调用 terminated()方法
		 System.out.println("TIDYING=2左移29位:"+TIDYING);
		 
		 int TERMINATED = 3 << COUNT_BITS;// terminated()方法执行完成
		 System.out.println("TERMINATED=3左移29位:"+TERMINATED);
	}
}
