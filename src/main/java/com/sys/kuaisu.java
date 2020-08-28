package com.sys;

import java.util.Arrays;

public class kuaisu {
	
	
	public static void main(String[] args) {
		long startime = System.currentTimeMillis();
		int num[]= {66,13,51,76,81,26,57,69,23};
//		Quicksort(num);
		QQuickSort(num,0,num.length-1);
		System.out.println(Arrays.toString(num));
		System.out.println("执行时间:"+(System.currentTimeMillis()-startime));
		 
	}
	
	 //快排
    static void QQuickSort(int[] nums,int low,int high){
        
        if(low<high) {
            int pivotpos = partition(nums,low,high);
            System.out.println("pivotpos:"+pivotpos);
            QQuickSort(nums,low,pivotpos-1);
            QQuickSort(nums,pivotpos+1,high);
        }
    }
    
    static int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        while(low<high) {
            while(low<high && nums[high]>=pivot) {
            	high--;
            }
            nums[low] = nums[high];
            System.out.println("low:"+low+"~~high:"+high+"对换之后"+Arrays.toString(nums));
            while(low<high && nums[low]<=pivot) { 
            	low++;
            }
            nums[high] = nums[low];
            System.out.println("low:"+low+"~~high:"+high+"对换之后"+Arrays.toString(nums));
        }
        nums[low] = pivot;
        System.out.println("index:为"+low+"轮:"+Arrays.toString(nums));
        return low;
            
    }
    
	//快速
	public static void Quicksort(int[]num) {
		int left =  0;
 		int right = num.length-1;
 		int temp = num[left];
		while (left<right) {
			System.out.println("num[]left:"+num[left]);
			System.out.println("num[]right:"+num[right]);
			if(temp>num[right]) {
				swap(num,left,right);
				left++;
			}else {
				right--;
			}
		}
		System.out.println(Arrays.toString(num));
	}
	public static void swap(int[]num,int l,int r) {
		int p = num[l];
		num[l] = num[r];
		num[r] = p;
	}
}
