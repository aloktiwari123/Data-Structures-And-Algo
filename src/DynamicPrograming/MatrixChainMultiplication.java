package DynamicPrograming;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static void main(String args[]) {
		int[]arr = {40,20,30,10,30};
		int[][]memo=new int[arr.length][arr.length];
		for(int[] temp:memo) {
			Arrays.fill(temp,-1);
		}
		System.out.println(solve(arr,1,arr.length-1));
		System.out.println(solveMemo(arr,1,arr.length-1,memo));
	}
	
	// Recursive Solution
	public static int solve(int arr[],int i,int j) {
		if(i>=j) {
			return 0;
		}
		int mn=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int temp=solve(arr,i,k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			if(temp<mn) {
				mn=temp;
			}
		}
		return mn;
	}
	
	public static int solveMemo(int arr[],int i,int j,int memo[][]) {
		if(i>=j) {
			return 0;
		}
		if(memo[i][j]!=-1) {
			return (memo[i][j]);
		}
		int mn=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int temp=solve(arr,i,k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			if(temp<mn) {
				mn=temp;
			}
		}
		memo[i][j]=mn;
		return memo[i][j];
	}
}
