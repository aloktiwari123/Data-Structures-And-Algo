package prefixSum;

public class NumberOfWaysToSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,4,-8,7};
		System.out.print(solve(nums));
	}
	
	public static int solve(int[] nums) {
		long[] prefixSum=new long[nums.length];
		int count=0;
		prefixSum[0]=nums[0];
		for(int i=1;i<nums.length;i++) {
			prefixSum[i]=prefixSum[i-1]+nums[i];
		}
		
		for(int i=0;i<nums.length-1;i++) {
			long rSum=prefixSum[nums.length-1]-prefixSum[i];
			long lSum=prefixSum[i];
			if(lSum>=rSum) count++;
		}
		return count;
	}

}
