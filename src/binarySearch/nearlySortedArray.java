package binarySearch;
// nearly sorted array
// if in sorted array element was supposed to be at i th then in this array it might be found at i th , i-1 th or i+1 th position
public class nearlySortedArray {
	
	public static void main(String args[]) {
		int[] arr= {5,10,30,20,40};
		System.out.println(binarySearch(arr,20));
	}
	public static int binarySearch(int[] arr,int k)
	{
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid=start+((end-start)/2);
			if(k== arr[mid]) {
				return mid;
			}
			if(mid-1 >= start && k== arr[mid-1]) {
				return mid-1;
			}
			if(mid+1 <= end && k== arr[mid+1]) {
				return mid+1;
			}
			
			if(k>arr[mid]) {
				start=mid+2;
			}
			else if(k<arr[mid]) {
				end=mid-2;
			}
			
		}
		return -1;
		
	}

}
