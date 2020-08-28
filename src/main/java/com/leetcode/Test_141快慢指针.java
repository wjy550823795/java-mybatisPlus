package com.leetcode;


public class Test_141快慢指针 {
	
	public static void main(String[] args) {
//		int a[] = {3,2,0,-4,2,-1};
		int a[] = {3,2,0,-4,2};
		boolean b = hasCycle(shengcheng(a));
		System.out.println(b);
		
	}
	
	 static class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	     }
	  }
	 public static ListNode shengcheng(int a[]) {
		 ListNode head = new ListNode(a[0]);
		 ListNode list = head ;
		 System.out.print(list.val+"-->");
		 for (int i = 1; i < a.length; i++) {
			 list.next = new ListNode(a[i]);
			 list = list.next;
			 System.out.print(list.val+"-->");
		 }
		 System.out.println();
		 return head;
	 }
	 
	 
	 public static boolean hasCycle(ListNode head) {
	    if (head == null || head.next == null) {
	        return false;
	    }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

	    
	}

}
