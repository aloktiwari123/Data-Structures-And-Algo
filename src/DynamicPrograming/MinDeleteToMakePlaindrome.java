package DynamicPrograming;

public class MinDeleteToMakePlaindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="agbcba";
		StringBuilder str=new StringBuilder(s1);
		str=str.reverse();
		System.out.println(s1.length()-solve(s1,str.toString()));
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

}
