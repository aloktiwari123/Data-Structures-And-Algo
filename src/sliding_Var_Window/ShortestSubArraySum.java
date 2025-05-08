package sliding_Var_Window;

public class ShortestSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {84,-37,32,40,95};
		int k = 167;
		System.out.print(solve(nums,k));
	}
	
	public static int solve(int[] nums,int k) {
		int i=0;
		int j=0;
		int sum=0;
		int min=Integer.MAX_VALUE;
		while(j<nums.length) {
			sum+=nums[j];
			if(sum<k) {
				j++;
			}else if(sum>=k) {
				while(sum>=k) {
					min=Math.min(min,j-i+1);
					sum-=nums[i];
					i++;
				}
				j++;
			}
		}
		return min==Integer.MAX_VALUE?-1:min;
	}

}
