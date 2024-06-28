package binarySearch;
import java.util.*;
public class countNegElements {

	public static void main(String args[]) {
		int[] arr= {6,5,4,3,2,-1,-2,-3};
		System.out.print((arr.length)-(solve(arr)));
	}
	
	public static int solve(int[] arr) {
		int res=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+((end-start)/2);
			
			if(arr[mid-1]>0 && arr[mid+1]<0) {
				return mid+1;
			}
			else if(arr[mid]<0) {
				end=mid-1;
			}
			else if(arr[mid]>0) {
				start=mid+1;
			}
		}
		
		return res;
	}
}
