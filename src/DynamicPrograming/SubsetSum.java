package DynamicPrograming;

public class SubsetSum {

	public static void main(String args[]) {
		int N = 6;
		int arr[] = {2,3,5,6,8,10};
		int sum = 10;
		System.out.print(solveDp(N,arr,sum));
	}
	
	// Recursive
	public static boolean solve(int n,int[] arr,int sum) {
		if(n==0) {
			return sum==0?true:false;
		}
		
		if(arr[n-1]<=sum) {
			return solve(n-1,arr,sum-arr[n-1]) || solve(n-1,arr,sum);
		}
		else {
			return solve(n-1,arr,sum);
		}
	}
	
	// DP
	public static boolean solveDp(int n,int[] arr,int sum) {
		boolean[][] t=new boolean[n+1][sum+1];
		for(int i=0;i<sum+1;i++) {
			t[0][i]=false;
		}
		for(int i=0;i<n+1;i++) {
			t[i][0]=true;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
				}
				else {
					t[i][j]=t[i-1][j];
				}
			} 
		}
		return t[n][sum];
	}
}
