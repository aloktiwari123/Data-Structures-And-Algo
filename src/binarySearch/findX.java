package binarySearch;

import java.util.Arrays;

public class findX {
	
	public static void main(String args[]) {
		int[] arr= {3,6,7,7,0};
		Arrays.sort(arr);
		for(int i=arr.length;i>=0;i--) {
			int idx=solve(arr,i);
			if((arr.length-idx)==i) {
				System.out.print(i);
			}
		}
	}
	
	public static int solve(int arr[],int k) {
		int start=0;
		int end=arr.length-1;
		int mid=0;
		int res=0;
		while(start<=end) {
			mid=start+((end-start)/2);
			
			if(arr[mid]==k) {
				start=mid+1;
			}
			if(arr[mid]<=k) {
				res=mid;
				start=mid+1;
			}
			else if(arr[mid]>k) {
				end=mid-1;
			}
		}
		return res;
	}

}
