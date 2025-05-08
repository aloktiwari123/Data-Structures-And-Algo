package binarySearch;

public class ShortestSubArrayToRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,10,4,2,3,5};
		System.out.print(solve(arr));
	}
	
	public static int solve(int[] arr) {
		int right=arr.length-1;
		int left=0;
		
		while(right>0 && arr[right-1]<=arr[right]) {
			right--;
		}
		int ans=right;
		while(left<right &&(left==0 || arr[left-1]<=arr[left])) {
			while(right<arr.length && arr[left]>arr[right]) {
				right++;
			}
			ans=Math.min(ans,right-left-1);
			left++;
		}
		return ans;
	}

}
