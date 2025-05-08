package stack;

import java.util.Stack;

public class MaxWidthRamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,8,1,0,1,9,4,0,4,1};
		System.out.print(solveStack(nums));
	}
	
	public static int solve(int[] nums) {
		int max=0;
		
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				if(nums[j]>=nums[i]) {
					max=Math.max(max, j-i);
				}
			}
		}
		return max;
	}
	
	public static int solveStack(int[] nums) {
		int max=0;
		Stack<Integer>index=new Stack<>();
		index.push(0);
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<nums[index.peek()]) {
				index.push(i);
			}
		}
		
		for(int i=nums.length-1;i>=0;i--) {
			while(!index.isEmpty() && nums[index.peek()]<=nums[i]) {
				max=Math.max(max,i-index.peek());
				index.pop();
			}
		}
		return max;
	}

}
