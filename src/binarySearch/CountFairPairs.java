package binarySearch;

import java.util.Arrays;

public class CountFairPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,7,4,4,5};
		int lower = 3;
		int upper = 6;
		
		System.out.print(solve(nums,lower,upper));
	}
	
	public static int solve(int[] arr,int low,int high) {
		Arrays.sort(arr);
		int count=0;
		
		for(int i=low;i<=high;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(low <= (arr[i]+arr[j]) && (arr[i]+arr[j]) <= high) {
					count++;
				}
			}
		}
		
		return count;
	}

}
