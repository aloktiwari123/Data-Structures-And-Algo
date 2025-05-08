package binarySearch;

public class MinLimitOfBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {9};
		int maxOperations = 2;
		System.out.println(solve(nums, maxOperations));
	}
	
	public static int solve(int[] nums,int maxOp) {
		int right=0;
		for(int  i=0;i<nums.length;i++) {
			right=Math.max(right,nums[i]);
		}
		int left=1;
		int result=right;
		while(left<right) {
			int mid=left+(right-left)/2;
			
			if(isPossible(mid,nums,maxOp)) {
				result=mid;
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return result;
	}
	
	public static boolean isPossible(int k,int[] nums,int maxOp) {
		int count=0;
		for(int i=0;i<nums.length;i++) {
			count+=(int)Math.ceil((double)nums[i]/k)-1;
		}
		return count<=maxOp;
	}

}
