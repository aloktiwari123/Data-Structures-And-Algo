package DynamicPrograming;

import java.util.Arrays;

// need to memoize the solution
public class LongestCommonSubsequence {
	public static void main(String args[]) {
		String s1="abcde";
		String s2="abce";
		int m=s1.length();
		int n=s2.length();
		int[][] memo=new int[m+1][n+1];
		for(int[] row:memo) {
			Arrays.fill(row,-1);
		}
		//System.out.print(solveMem(s1.length(),s2.length(),s1,s2,memo));
		System.out.print(printLCS(s1.length(),s2.length(),s1,s2,""));
		//System.out.print(solveDP(s1,s2));
	}
	
	// recursive solution
	public static int solve(int m,int n,String s1,String s2) {
		if(m==0||n==0) {
			return 0;
		}
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			return 1+solve(m-1,n-1,s1,s2);
		}
		else {
			return Math.max(solve(m-1,n,s1,s2),solve(m,n-1,s1,s2));
		}
	}
	
	
	// memoized Solution
	public static int solveMem(int m,int n,String s1,String s2,int[][] memo) {
		if(m==0||n==0) {
			return 0;
		}
		if(memo[m][n]!=-1) {
			return memo[m][n];
		}
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			memo[m][n]= 1+solveMem(m-1,n-1,s1,s2,memo);
		}
		else {
			memo[m][n]=Math.max(solveMem(m-1,n,s1,s2,memo),solveMem(m,n-1,s1,s2,memo));
		}
		return memo[m][n];
	}
	
	//DP
	
	public static int solveDP(String s1,String s2) {
		int n=s1.length();
		int m=s2.length();
		int[][] t=new int[n+1][m+1];
		for(int i=0;i<n+1;i++) {
			t[i][0]=0;
		}
		for(int i=0;i<m+1;i++) {
			t[0][i]=0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					t[i][j]=1+t[i-1][j-1];
				}
				else {
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
				}
			}
		}
		
		return t[n][m];
	}
	
	
	public static String printLCS(int m,int n,String s1,String s2,String op) {
		if(m==0 || n==0) {
			if(m==0 && n==0) {
				return op;
			}
			else {
				return "";
			}
		}
		
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			return printLCS(m-1,n-1,s1,s2,op+s1.charAt(m-1));
		}
		else {
			String op1=printLCS(m-1,n,s1,s2,op);
			String op2=printLCS(m,n-1,s1,s2,op);
			return op1.length()>op2.length()?op1:op2;
		}
	}
	
}
