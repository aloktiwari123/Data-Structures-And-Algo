package binarySearch;

public class searchInSortedMatrix {
	public static void main(String args[]) {
		int[][] arr= {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int k=16;
		System.out.print(search(arr,k));
		
	}
	
	public static String search(int[][] arr,int k) {
		int i=0;
		int n=arr.length;
		int m=arr[0].length;
		int j=arr[0].length-1;
		
		while(i>=0 && i<n && j>=0 && j<m) {
			if(arr[i][j]==k) {
				return i+","+j;
			}
			else if(arr[i][j]>k) {
				j--;
			}
			else if(arr[i][j]<k) {
				i++;
			}
		}
		return "-1,-1";
	}

}
