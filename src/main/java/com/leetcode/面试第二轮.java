package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 面试第二轮 {
	 public static void main(String[] args) {
	        //Scanner in = new Scanner(System.in);
	        //int a = in.nextInt();
	        //System.out.println(a);
	        System.out.println("Hello World!");
	        int a[] = {1,6,5,2,7,9,3};
	        List<List<Integer> > arrayList = new ArrayList<>();
	        Arrays.sort(a);
	        System.out.println(Arrays.toString(a));
	        for(int i=0;i<a.length;i++){
	        	int sumeight = sumeight(0,a.length-1,a,8-a[i]);
	            if(sumeight!=-1){
	               List<Integer> varlist = new ArrayList<>();
	               varlist.add(a[i]);
	               varlist.add(sumeight);
	               arrayList.add(varlist);
	            }
	        }
	       System.out.println(arrayList.toString());
	    }
	    public static int sumeight(int left,int right,int num[],int k){
	        int middle = (left+right)/2;
	        if(k>num[right]||k<num[left]||left>right){
	            return -1;
	        }
	        if(k>num[middle]){
	            return sumeight(middle+1,right,num,k);
	        }else if(k<num[middle]){
	             return sumeight(left,middle-1,num,k);
	        }else{
	            return num[middle];
	        }    
	    }
}
