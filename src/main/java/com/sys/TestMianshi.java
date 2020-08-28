package com.sys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

import com.sys.entity.BinaryTree;

public class TestMianshi {
	public static void main(String[] args) {
		// 1.
//	System.out.println(findTheDifference("abcd","abcde"));
		// 2.
//	int[] nums = {5,5,3,2,3,3,4};
//	System.out.println(longestConsecutive(nums));
		// 3.
//	test1();
//	test2();
//	compressString("bbbbcccd");
//	System.out.println(isFlipedString("waterbottle","erbottlewat"));

//	System.out.println(addDigits(27));
//	System.out.println(27%9);
		
//	int[] nums = {7,9,10,1000,3,2};
//	System.out.println(massage(nums));
		
//	System.out.println(numOfBurgers(16,7));	
//		  int max = Integer.MIN_VALUE;
//		  System.out.println(max);
		
		TreeNode root = new TreeNode(1);
		
		TreeNode left1 = new TreeNode(3);
		root.left=left1;
		
		TreeNode right1 = new TreeNode(2);
		root.right=right1;
		
		TreeNode left3 = new TreeNode(5);
		left1.left=left3;
		
		TreeNode right3 = new TreeNode(3);
		left1.right=right3;
		
		TreeNode right2 = new TreeNode(9);
		right1.right = right2; 
		
		TreeNode left2 = new TreeNode(14);
		right1.left = left2; 
//		
//		System.out.println(largestValues(root));
		
		
//		int[]nums = {3,30,34,5,9};
//		System.out.println(largestNumber(nums));
		
		//112.
//		System.out.println(hasPathSum(root,17));
		
		//1209.
//		System.out.println(removeDuplicates("pbbbcggttciiippooaais",2));
		
//		int n = 0,m=0;
//		m=n---1;
//		System.out.println(n);
//		System.out.println(m);
		System.out.println(cakeNumber(4));
		
	}

	public static void check(int[] num,int m ) {
		
		boolean flag = true;
		while (flag) {
			int result = 0;
			for (int i = 0; i < 4; i++) {
				int index=(int)(Math.random()*num.length);
				result+=num[index];
			}
			if(result==m) {
				flag = false;
				break;
			}
		}
		
	}
//	public  static int selectPresent() {
//		        int n = pv.size();  if(n == 0) return 0;
//		        int m = pv[0].size();
//		        for(int i = 1; i < n; i++)  pv[i][0] += pv[i-1][0];
//		        for(int i = 1; i < m; i++)  pv[0][i] += pv[0][i-1];
//		        for(int i = 1; i < n; i++)
//		            for(int j = 1; j < m; j++) 
//		                pv[i][j] += min(pv[i][j-1], min(pv[i-1][j], pv[i-1][j-1]));
//		        return pv[n-1][m-1];
//    }
	
	
	public  static int cakeNumber (int n) {
		 int x= 1;
		 for (int i = 1; i < n; i ++)
	            x = (x+1)*3/2;
	        return x;
	}
	
	public static String removeDuplicates(String s, int k) {
		
		int qian = s.length();
		System.out.println("qian:"+qian);
		s=s.replaceAll("(\\w)\\1{"+(k-1)+"}", "");
		int hou = s.length();
		System.out.println("hou:"+hou);
		if(qian!=hou) {
			s = removeDuplicates(s,k);
		}
		return s;
		
    }
	
	static boolean  ans = false;
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root,sum);
        return ans;
    }
    
    private static void dfs(TreeNode root,int sum) {
        if (root == null) {
        	System.out.println("被返回的叶子节点:");
            return;
        }
        
        System.out.println("root.val前:"+root.val+"&&sum:"+sum);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                ans = true;
            }
        }
        dfs(root.left,sum - root.val);
        dfs(root.right,sum - root.val);
        
//        System.out.println(root.val);
//        System.out.println("sum:"+sum);
        
//        
    }


	
	 public static String largestNumber(int[] nums) {
		 StringBuilder res = new StringBuilder();
		 
		 //取最小值
		 Object[] array = Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((y, x) -> (x + y).compareTo(x + y)).toArray();
		 System.out.println("array:"+Arrays.toString(array));
		 
		 //取最大值
//		 Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(x -> res.append(x));
		 Object[] array2 = Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).toArray();
		 System.out.println("array2:"+Arrays.toString(array2));
		
		 //默认排序
		 int[] array3 = Arrays.stream(nums).sorted().toArray();
		 System.out.println("array3:"+Arrays.toString(array3));
//		 return res.charAt(0) == '0' ? "0" : res.toString();
		 return "1";
     }
	
	//Queue 队列先进先出
	//Stack  栈 先进后出
	public static List<Integer> largestValues(TreeNode root) {
//	//LinkedList实现队列
	    Queue<TreeNode> queue = new LinkedList<>();
	    List<Integer> values = new ArrayList<>();
	    if (root != null)
	        queue.add(root);//入队
	    	System.out.println("queue初始值:"+queue.toString());
	    while (!queue.isEmpty()) {
	        int max = Integer.MIN_VALUE;
	        int levelSize = queue.size();//每一层的数量
	        System.out.println("queue的值:"+queue.toString());
	        System.out.println("levelSize:"+levelSize);
	        for (int i = 0; i < levelSize; i++) {
	            TreeNode node = queue.poll();//出队
	            max = Math.max(max, node.val);//记录每层的最大值
	            if (node.left != null)
	                queue.add(node.left);
	            if (node.right != null)
	                queue.add(node.right);
	        }
	        values.add(max);
	    }
	    return values;
    }
	 
		 
		 
	 public static int maxDepth(TreeNode root)  {
		 return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
	  
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	
	
	 public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		  List<Integer> ansList = new ArrayList<>();
	        if (tomatoSlices%2 ==1) {
	            return ansList;
	        }
	        int y = cheeseSlices*2- tomatoSlices/2;
	        if (y < 0) {
	            return ansList;
	        }
	        
	        int x = cheeseSlices-y;
	        if (x < 0) {
	            return ansList;
	        }
	        ansList.add(x);
	        ansList.add(y);

	        return ansList;
     }
	 
	 

	public static int massage(int[] nums) {
		int a = 0, b = 0;
		for (int i = 0; i < nums.length; i++) {
//			System.out.println("i:"+i);
//			System.out.println("a:"+a);
//			System.out.println("b:"+b);
			int c = Math.max(b, a + nums[i]);
//			System.out.println("c:"+ c);
			a = b;
			b = c;
//			System.out.println("~~~~~~~~~~~~~~~");
		}
		return b;
	}

	public static int addDigits(int num) {
		if (num != 0) {
			if (num % 9 == 0) {
				return 9;
			}
			return num % 9;
		}
		return num;
	}

//	public class ListNode {
//		int val;
//		ListNode next;
//
//		ListNode(int x) {
//			val = x;
//		}
//	}

	public static boolean isFlipedString(String s1, String s2) {
		char[] ss1 = s1.toCharArray();
		int hash1 = 0;
		int hash2 = 0;
		for (int i = 0; i < ss1.length; i++) {
			hash1 += ss1[i];
		}
		char[] ss2 = s2.toCharArray();
		for (int i = 0; i < ss2.length; i++) {
			hash2 += ss2[i];
		}
		if (hash1 == hash2) {
			return true;
		}
		return false;
	}

	public static String compressString(String S) {
		StringBuilder a = new StringBuilder();
		if (S.length() > 0) {
			char hh = S.charAt(0);
			int n = 1;
			for (int i = 0; i < S.length(); i++) {
				if (i > 0) {
					if (hh == S.charAt(i)) {// 相同
						n++;
					} else {// 不同
						a.append(hh);
						a.append(n);
						hh = S.charAt(i);
						n = 1;
					}
				}
				if (i == S.length() - 1) {
					a.append(hh);
					a.append(n);
				}
			}
			if (S.length() > a.length()) {
				return a.toString();
			}
		}
		return S;
	}

	public static void test2() {
		BinaryTree bt = new BinaryTree();
		bt.add(8);
		bt.add(3);
		bt.add(10);
		bt.add(1);
		bt.add(6);
		bt.add(14);
		bt.add(4);
		bt.add(7);
		bt.add(13);
		bt.print();// 中序遍历可以从小到大排序
	}

	public static void test1() {
		int b[][] = { { 1 }, { 2, 2 }, { 2, 2, 2 } };
		int sum = 0;
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i].length);
			for (int j = 0; j < b[i].length; j++) {
				sum += b[i][j];
			}
		}
		System.out.println(sum);
	}

	public static char findTheDifference(String s, String t) {
		char res = 0;
		int lens = s.length();
		for (int i = 0; i < lens; i++) {
			res ^= s.charAt(i) ^ t.charAt(i);
		}
		res ^= t.charAt(lens);
		return res;
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> numsSet = new HashSet<>();
		for (Integer num : nums) {
			numsSet.add(num);
		}
		int longest = 0;
		for (Integer num : nums) {
			if (numsSet.remove(num)) {
				// 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
				int currentLongest = 1;
				int current = num;
				while (numsSet.remove(current - 1))
					current--;
				currentLongest += (num - current);
				// 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
				current = num;
				while (numsSet.remove(current + 1))
					current++;
				currentLongest += (current - num);
				// 搜索完后更新longest.
				longest = Math.max(longest, currentLongest);
			}
		}
		return longest;
	}

}
