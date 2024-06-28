package prefixSum;

public class SubArraySumDivisibleByK {

	public static void main(String args[]) {
		int[] nums= {4,5,0,-2,-3,1};
		int k=5;
		System.out.print(solve(nums,k));
	}
	
	public static int solve(int[] nums,int k) {
		int[] remF=new int[k];
		int sum=0;
		int count=0;
		remF[0]=1;
		// s1=k*n+x;
		// s2=k*m+x;
		// s2-s1=k(m-n)
		// hence s2-s1 is divisible by k if the remainder is same
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			int rem=sum%k;
			if(rem<0) rem=rem+k;
			count+=remF[rem];
			remF[rem]++;
		}
		return count;
	}
}
