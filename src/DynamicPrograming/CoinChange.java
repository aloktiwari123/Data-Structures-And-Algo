package DynamicPrograming;

public class CoinChange {
	
	public static void main(String args[]) {
		int sum=4;
		int[] arr= {1,2,3};
		System.out.println(solve(arr.length,arr,sum));
		System.out.print(solveDp(arr.length,arr,sum));
	}
	
	public static int solve(int n,int[] arr,int sum) {
		if(n==0) {
			return sum==0?1:0;
		}
		
		if(arr[n-1]<=sum) {
			return solve(n,arr,sum-arr[n-1])+solve(n-1,arr,sum);
		}
		else {
			return solve(n-1,arr,sum);
		}
	}
	
	public static int solveDp(int n,int[] arr,int W) {
		int[][]t=new int[n+1][W+1];
		for(int i=0;i<W+1;i++) {
			t[0][i]=0;
		}
		for(int i=0;i<n+1;i++) {
			t[i][0]=1;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i][j-arr[i-1]]+t[i-1][j];
				}
				else {
					t[i][j]=t[i-1][j];
				}
			} 
		}
		return t[n][W];
	}

}
