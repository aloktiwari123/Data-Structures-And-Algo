package DynamicPrograming;

public class LongestPalindromicSubsequence {

	public static void main(String args[]) {
		String s1="agbcba";
		String s2="";
		StringBuilder s3=new StringBuilder();
		for(char ch:s1.toCharArray()) {
			s3.append(ch);
		}
		System.out.println(solve(s1,s2));
		System.out.println(solveDP(s1,s2));
	}
	
	public static int solve(String s1,String s2) {
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
	
	//print longest plaindromic subsquence
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
}
