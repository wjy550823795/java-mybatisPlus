package com.lianxi;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Shabi {
	public static void main(String[] args) {
//		Map<Object, Object> map = new LinkedHashMap<>();
//			map.put("1dsada23", "1asdasd23");
//			map.put("4asdasd56", "456asdasda");
//			map.put("789asdasd", "789sadasdas");
//		System.out.println(map.toString());
//		
		//后进先出
		Stack<Object> stack = new Stack<>();
		stack.push("123");
		stack.push("456");
		stack.push("789");
		System.out.println(stack.pop());//pop栈顶
		System.out.println("saldhaslijdhoi"+stack.elements().nextElement());//是否还有元素
		System.out.println(stack.pop());//pop栈顶
//		System.out.println(stack.pop());//pop栈顶
		System.out.println(stack.peek());
		
//		List<Object> varlist = new ArrayList<>();
//			varlist.add(222);
//			varlist.add(1111);
//			varlist.add(333);
//		Deque<Object> de = new LinkedList<>(varlist);
//		
//	    Queue<Object> queue = new LinkedList<Object>(varlist);
//	    
//		System.out.println(de.toString());
//		de.offer(123);
//		de.offer(789);
//		de.offer("asdasda");
//		System.out.println(de.peek()); //不会删除 单纯取值
//		System.out.println(de.poll());//推出去 删除值
//		System.out.println(de.poll());//推出去 删除值
//		System.out.println(de.poll());//推出去 删除值
//		System.out.println(de.poll());//推出去 删除值
//		System.out.println(de.poll());//推出去 删除值
//		System.out.println(de.poll());//推出去 删除值
//		System.out.println(de.peek());//当队列为null时 返回null
//		System.out.println(de.element());//当队列为null时 抛出异常
//		de.poll();
	}
	
    

}
