package DynamicPrograming;

public class SubSetsWithDiff {
	public static void main(String args[]) {
		int N = 4;
		int arr[] = {1,1,2,3};
		int sum = 7;
		int diff=1;
		sum=(diff+sum)/2;
		System.out.print(solveDp(N,arr,sum));	
	}
	
	// DP
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
