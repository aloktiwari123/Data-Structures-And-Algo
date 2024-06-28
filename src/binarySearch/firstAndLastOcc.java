package binarySearch;

public class firstAndLastOcc {
	
	public static void main(String args[]) {
		int[] arr= {1,4,10,10,10,18,20};
		System.out.println(firstOcc(arr,10));
		System.out.println(lastOcc(arr,10));
		
	}
	
	public static int firstOcc(int[] arr,int num) {
		int res=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+((end-start)/2);
			
			if(num == arr[mid]) {
				res=mid;
				end=mid-1;
			}
			else if(num > arr[mid]) {
				start=mid+1;
			}
			else if(num < arr[mid]) {
				end=mid-1;
			}
		}
		
		return res;
	}
	
	public static int lastOcc(int[] arr,int num) {
		int res=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+((end-start)/2);
			
			if(num == arr[mid]) {
				res=mid;
				start=mid+1;
			}
			else if(num > arr[mid]) {
				start=mid+1;
			}
			else if(num < arr[mid]) {
				end=mid-1;
			}
		}
		
		return res;
		
	}

}
