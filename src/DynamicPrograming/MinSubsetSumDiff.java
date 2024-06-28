package DynamicPrograming;

public class MinSubsetSumDiff {

	public static void main(String args[]) {
		int N = 3;
		int arr[] = {1,2,7};
		int sum = 10;
		System.out.print(solveDp(N,arr,sum));	
	}
	
	// DP
	public static int solveDp(int n,int[] arr,int sum) {
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
		int min=Integer.MAX_VALUE;
		for(int i=0;i<sum/2;i++) {
			if(t[n][i]) {
				min=Math.min(min,sum-2*(i));
			}
		}
		return min;
	}
}
