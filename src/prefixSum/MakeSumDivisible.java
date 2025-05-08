package prefixSum;

public class MakeSumDivisible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {6,3,5,2};
		int p = 9;
		System.out.print(solve(nums,p));
	}
	
	public static int solve(int[] nums,int p) {
		int totalSum=0;
		int minLen=Integer.MAX_VALUE;
		for(int num:nums) {
			totalSum+=num;
		}
		
		for(int start=0;start<nums.length;start++) {
			int subSum=0;
			for(int i=start;i<nums.length;i++) {
				subSum+=nums[i];
				
				if((totalSum-subSum)%p==0) {
					minLen=Math.min(minLen,i-start+1);
				}
			}
		}
		
		return minLen==Integer.MAX_VALUE?-1:minLen;
		
	}

}
