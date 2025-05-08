package Greedy;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,1,4};
		System.out.print(solve(nums));
	}
	
	public static boolean solve(int[] nums) {
		int maxReach=0;
		
		for(int i=0;i<nums.length;i++) {
			if(i>maxReach)return false;
			maxReach=Math.max(maxReach, i+nums[i]);
		}
		
		return true;
	}

}
