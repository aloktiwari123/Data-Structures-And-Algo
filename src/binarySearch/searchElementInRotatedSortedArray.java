package binarySearch;

public class searchElementInRotatedSortedArray {
	
	public static void main(String args[]) {
		int[] arr= {4,5,6,7,0,1,2};
		int idx=countOfRotation(arr);
		int idx1=binarySearch(arr,0,idx-1,0);
		int idx2=binarySearch(arr,idx,arr.length-1,0);
		System.out.print(idx1==-1?idx2:idx1);
	}

	public static int countOfRotation(int[] arr) {
		int start=0;
		int end=arr.length-1;
		int n=arr.length;
		while(start<=end) {
			int mid=start +((end-start)/2);
			int prev=(mid+n-1)%n;
			int next=(mid+1)%n;
			if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]) {
				return mid;
			}
			if(arr[0]<=arr[mid]) {
				start=mid+1;
			}
			else if(arr[end]>=arr[mid]) {
				end=mid-1;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int[] arr,int start,int end,int k) {
		while(start<=end) {
			int mid=start+((end-start)/2);
			if(arr[mid]==k) {
				return mid;
			}
			else if(arr[mid]<k) {
				start=mid+1;
			}
			else if(arr[mid]>k) {
				end=mid-1;
			}
		}
		return -1;
	}

}
