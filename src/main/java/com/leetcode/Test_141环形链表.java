package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test_141环形链表 {
	public static void main(String[] args) {
		
	}
	 class ListNode {
	     int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		     }
		  }
		
	    public boolean hasCycle(ListNode head) {
	        Map<Object, Object> Map = new HashMap<>();
//	        Set<ListNode> nodesSeen = new HashSet<>();
	        while (head.next!=null){
				if(Map.containsKey(head.val)) {
					return false;
				}else {
					Map.put(head.val, head.val);
				}
				 head = head.next;	
			}
	        return true;
	    }
}
