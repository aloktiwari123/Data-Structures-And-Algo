package DynamicPrograming;

import java.util.Arrays;

public class PrintLCS {
	public static void main(String args[]) {
		String s1="acbcf";
		String s2="abcdaf";
		int m=s1.length();
		int n=s2.length();
		int[][] memo=new int[m+1][n+1];
		for(int[] row:memo) {
			Arrays.fill(row,-1);
		}
		//System.out.print(solveMem(s1.length(),s2.length(),s1,s2,memo));
		//System.out.println(printLCS(0,0,s1,s2,""));
		//System.out.println(solve(s1,s2));
		System.out.println(solveDP(s1,s2));
	}
	
	
	public static String printLCS(int m,int n,String s1,String s2,String op) {
		if(m==s1.length() || n==s2.length()) {
			if(m==s1.length() && n==s2.length()) {
				return op;
			}
			else {
				return "";
			}
		}
		
		if(s1.charAt(m)==s2.charAt(n)) {
			return printLCS(m+1,n+1,s1,s2,op+s1.charAt(m));
		}
		else {
			String op1=printLCS(m+1,n,s1,s2,op);
			String op2=printLCS(m,n+1,s1,s2,op);
			return op1.length()>op2.length()?op1:op2;
		}
	}
	
	// using lcs top-down
	public static String solveDP(String s1,String s2) {
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
		int i=n;
		int j=m;
		String s="";
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				s=s1.charAt(i-1)+s;
				i--;
				j--;
			}
			else {
				if(t[i-1][j]>t[i][j-1]) {
					i--;
				}
				else {
					j--;
				}
			}
		}
		return s;
	}
	
	
	public static String solve(String s1,String s2) {
		int n=s1.length();
		int m=s2.length();
		String [][]t=new String[n+1][m+1];
		for(int i=0;i<n+1;i++) {
			t[i][0]="";
		}
		for(int i=0;i<m+1;i++) {
			t[0][i]="";
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					t[i][j]=t[i-1][j-1]+s1.charAt(i-1);
				}
				else {
					String op1=t[i-1][j];
					String op2=t[i][j-1];
					t[i][j]= op1.length()>op2.length()?op1:op2;
				}
			}
		}
		for(String[] row:t) {
			System.out.println(Arrays.toString(row));
		}
		return t[n][m];
	}
}
