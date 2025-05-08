package Sorting;

import java.util.Arrays;

public class PowerOfSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,3,2,5};
		int k = 3;
		solve(nums, k);
	}
	
	public static int[] solve(int[] arr,int k) {
		int[] ans=new int[arr.length-k+1];
		
		for(int i=0;i<arr.length-k+1;i++) {
			ans[i]=getPower(i,i+k,arr);
		}
		
		System.out.print(Arrays.toString(ans));
		return ans;
	}
	
	public static int getPower(int start,int end,int[] arr) {
		int num=arr[start];
		int max=num;
		for(int i=start+1;i<end;i++) {
			if(arr[i]!=++num) return -1;
			max=Math.max(max,arr[i]);
		}
		return max;
	}

}
