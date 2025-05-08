package DynamicPrograming;

public class MaxNumberPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]points = {{1,2,3},{1,5,1},{3,1,1}};
		System.out.print(solve(0,0,points,0));
	}
	
	
	public static long solve(int row,int column,int arr[][],int score) {
		if(row==arr.length) return score;
		
		long max=Integer.MIN_VALUE;
		long temp;
		for(int i=0;i<arr[0].length;i++) {
			if(row==0 && column==0) {
				temp=solve(row+1,i,arr,score+arr[row][i]);
			}
			else {
				int nScore=score+arr[row][i]-Math.abs(i-column);
				temp=solve(row+1,i,arr,nScore);
			}
			max=Math.max(max,temp);
			
		}
		
		return max;
		
	}
	
	public static void solveDp(int row,int column,int arr[][],int score) {
		int n=arr.length;
		int m=arr[0].length;
		int[][] dp=new int[n][m];
		
		for(int i=0;i<n;i++) {
			dp[0][i]=arr[0][i];
		}
		
		for(int i=0;i<m;i++) {
			dp[i][0]=arr[i][0];
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				
			}
		}
		
	}


}
