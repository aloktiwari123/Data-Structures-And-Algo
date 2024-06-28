package BackTracking;
import java.util.*;
public class LargestDivisibleSubset {

	public static void main(String args[]) {
		int[] nums= {22,1,74,51,18,38,9,44,88,12};
		int[] dp=new int[nums.length];
		Arrays.fill(dp,-1);
		System.out.println(solveDp(nums,0,new ArrayList<>(),dp));
		//System.out.println(solve(nums,nums.length,new ArrayList<>()));
	}
	
	public static List<Integer> solveDp(int[] arr,int idx,List<Integer>op,int[] dp){
		if(idx==arr.length) {
			return new ArrayList<>(op);
		}
		int num=arr[idx];
		if(op.size()>dp[idx] && isValid(num,op)) {
			dp[idx]=op.size();
			List<Integer>op1=new ArrayList<>(op);
			op1.add(num);
			List<Integer>s=solveDp(arr,idx+1,op,dp);
			List<Integer>ns=solveDp(arr,idx+1,op1,dp);
			return s.size()>ns.size()?s:ns;
		}
		else {
			return solveDp(arr,idx+1,op,dp);
		}
	}
	
	public static List<Integer> solve(int[] arr,int idx,List<Integer>op){
		if(idx==0) {
			return new ArrayList<>(op);
		}
		int num=arr[idx-1];
		if(isValid(num,op)) {
			List<Integer>op1=new ArrayList<>(op);
			op1.add(num);
			List<Integer>ns=solve(arr,idx-1,op);
			List<Integer>s=solve(arr,idx-1,op1);
			return s.size()>ns.size()?s:ns;
		}
		else {
			return solve(arr,idx-1,op);
		}
		

	}
	
	public static boolean isValid(int num,List<Integer>op) {
		if(op.isEmpty()) {
			return true;
		}
		else {
			for(int n:op) {
				if(n%num!=0 && num%n!=0) {
					return false;
				}
			}
		}
		return true;
	}
}
