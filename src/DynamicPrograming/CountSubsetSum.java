package DynamicPrograming;
import java.util.*;
public class CountSubsetSum {
	static int[][] t=new int[100][100];
	public static void main(String args[]) {
		int N = 6;
		int arr[] = {2,3,5,6,8,10};
		int sum = 10;
		for(int[] temp:t) {
			Arrays.fill(temp,-1);
		}
		System.out.print(solveDp(N,arr,sum));
	}
	
	public static int solve(int n,int[] arr,int sum) {
		if(n==0) {
			return sum==0?1:0;
		}
		if(t[n][sum]!=-1) {
			return t[n][sum];
		}
		
		if(arr[n-1]<=sum) {
			t[n][sum]= solve(n-1,arr,sum-arr[n-1]) + solve(n-1,arr,sum);
		}
		else {
			t[n][sum]=solve(n-1,arr,sum);
		}
		return t[n][sum];
	}
	
	public static int solveDp(int n,int[] arr,int sum) {
		int[][] t=new int[n+1][sum+1];
		for(int i=0;i<sum+1;i++) {
			t[0][i]=0;
		}
		for(int i=0;i<n+1;i++) {
			t[i][0]=1;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
				}
				else {
					t[i][j]=t[i-1][j];
				}
			} 
		}
		return t[n][sum];
	}

}
