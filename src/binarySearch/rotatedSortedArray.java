package binarySearch;
public class rotatedSortedArray {
	
	public static void main(String args[]) {
		int[] arr= {11,13,15,17};
		System.out.print(countOfRotation(arr));
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
			// if arr[mid] greater that first element this means left is sorted
			else if(arr[0]<=arr[mid]) {
				start=mid+1;
			}
			// if arr[mid] is less than the last elements this means right is sorted
			else if(arr[arr.length-1]>=arr[mid]) {
				end=mid-1;
			}
		}
		return arr[0];
	}
}
