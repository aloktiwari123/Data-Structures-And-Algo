package binarySearch;

public class peakElement {
	public static void main(String args[]) {
		int[] arr= {1,2,1,3,5,6,4};
		System.out.println(binarySearch(arr));
	}
	
	public static int binarySearch(int[] arr) {
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+((end-start)/2);
			if(mid>0 && mid<arr.length-1) {
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
					return mid;
				}
				else if(arr[mid-1]>arr[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			else if(mid==0) {
				if(arr[mid]>arr[mid+1]) {
					return mid;
				}
				else {
					return mid+1;
				}
			}
			else if(mid==arr.length-1) {
				if(arr[mid]>arr[mid-2]) {
					return mid;
				}
				else {
					return mid-2;
				}
			}
		}
		
		return -1;
	}
	
	public static int solve(int[] arr) {
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+((end-start)/2);
			if(mid>0 && mid<arr.length-1) {
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
					return mid;
				}
				else if(arr[mid-1]>arr[mid]) {
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			else if(mid==0) {
				if(arr[mid]>arr[mid+1]) {
					return mid;
				}
			}
			else if(mid==arr.length-1) {
				if(arr[mid]>arr[mid-2]) {
					return mid;
				}
			}
		}
		return -1;
	}


}
