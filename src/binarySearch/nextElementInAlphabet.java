package binarySearch;

public class nextElementInAlphabet {
	
	public static void main(String args[]) {
		char[] arr= {'a','c','f','h'};
		System.out.println(binarySearch(arr,'f'));
	}
	
	public static char binarySearch(char[] arr, char k) {
		int start=0;
		int end=arr.length;
		char res=' ';
		while(start<=end) {
			int mid=start+((end-start)/2);
			
			if(arr[mid]==k) {
				start=mid+1;
			}
			else if(arr[mid]<k) {
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
