package binarySearch;

public class floorCeilInSortedArray {
	
	public static void main(String args[]) {
		int[] arr= {1,2,3,4,8,10,10,12,13};
		int k=5;
		System.out.println(binarySearch(arr,5));
		System.out.println(binarySearch_ceil(arr,5));
	}
	
	public static int binarySearch(int[] arr,int k) {
		int start=0;
		int end=arr.length-1;
		int res=0;
		while(start<=end) {
			int mid=start+((end-start)/2);
			
			if(arr[mid]==k) {
				return k;
			}
			
			if(arr[mid]<k) {
				res=arr[mid];
				start=mid+1;
			}
			else if(arr[mid]>k) {
				end=mid-1;
			}
		}
		return res;
	}
	
	public static int binarySearch_ceil(int[] arr,int k) {
		int start=0;
		int end=arr.length-1;
		int res=0;
		while(start<=end) {
			int mid=start+((end-start)/2);
			
			if(arr[mid]==k) {
				return k;
			}
			
			if(arr[mid]<k) {
				start=mid+1;
			}
			else if(arr[mid]>k) {
				res=arr[mid];
				end=mid-1;
			}
		}
		return res;
	}

}
