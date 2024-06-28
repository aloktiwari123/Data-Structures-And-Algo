package DynamicPrograming;

public class O1KnapSack {
	public static void main(String args[]) {
		int N = 3;
		int W = 4;
		int values[] = {1,2,3};
		int weight[] = {4,5,1};
		System.out.println(solveDp(values,weight,N,W));
	}
	
	// Recursive Solution
	public static int solve(int[]values,int[]weights,int n,int W) {
		if(W==0 || n==0) {
			return 0;
		}
		
		if(weights[n-1]<=W) {
			return Math.max(values[n-1]+solve(values,weights,n-1,W-weights[n-1]),solve(values,weights,n-1,W));
		}
		else {
			return solve(values,weights,n-1,W);
		}
	}
	
	// DP
	
	public static int solveDp(int[]values,int[]w,int n,int W) {
		int[][]t=new int[n+1][W+1];
		for(int i=0;i<n+1;i++) {
			t[i][0]=0;
		}
		for(int i=0;i<W+1;i++) {
			t[0][i]=0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(w[i-1]<=j) {
					t[i][j]=Math.max(values[i-1]+t[i-1][j-w[i-1]],t[i-1][j]);
				}
				else {
					t[i][j]=t[i-1][j];
				}
			} 
		}
		return t[n][W];
	}

}
