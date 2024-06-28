package sliding_Var_Window;
// Longest subarray with sum as k (sliding window)

public class LongestSubarray {
	
	public static void main(String args[]) {
		int[] arr= {4,1,1,1,2,3,5};
		System.out.print(longestSubarray(arr,5));
	}
	
	public static int longestSubarray(int[] arr,int k) {
		int max=0;
		int i=0,j=0;
		int sum=0;
		while(j<arr.length) {
			sum=sum+arr[j];
			
			if(sum<k) {
				j++;
			}
			else if(sum==k) {
				max=Math.max(max,(j-i+1));
				j++;
			}
			else {
				while(sum>k) {
					sum=sum-arr[i];
					i++;
				}
				j++;
			}
		}
		
		return max;
	}

}
