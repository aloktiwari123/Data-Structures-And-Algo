package recursion;

public class LCS {
	public static void main(String args[]) {
		String s1="abc";
		String s2="def";
		System.out.print(solve(s1.length(),s2.length(),s1,s2));
	}
	
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

}
