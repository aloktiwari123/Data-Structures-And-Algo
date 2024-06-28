package DynamicPrograming;

import java.util.*;

public class PerfectSquare {
	
	public static void main(String args[]) {
		int[]dp=new int[13+1];
		Arrays.fill(dp,-1);
		//System.out.print(solve(13,dp));
		//System.out.print(Arrays.toString(dp));
		List<Integer>choices=new ArrayList<>();
		for(int i=1;i*i<=12;i++) {
			choices.add(i*i);
		}
		System.out.print(solve(13,choices,choices.size()));
		
	}
	
	public static int solve(int n,int[] dp) {
		if(n==0) {
			return 0;
		}
		if(n<0) {
			return Integer.MAX_VALUE;
		}
		if(dp[n]!=-1) return dp[n];
		int min=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int pf=i*i;
			min= Math.min(1+solve(n-pf,dp),min);
		}
		return dp[n]=min;
	}
	
	// Recursive Solution
	public static int solve(int n,List<Integer> choices,int idx) {
		if(idx==0) {
			 return n==0?0:Integer.MAX_VALUE;
		}
		if(choices.get(idx-1)<=n) {
			return Math.min(1+solve(n-choices.get(idx-1),choices,idx),solve(n,choices,idx-1));
		}
		else {
			return solve(n,choices,idx-1);
		}
	}

}
