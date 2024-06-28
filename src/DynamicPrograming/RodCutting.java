package DynamicPrograming;

public class RodCutting {

	public static void main(String args[]) {
		int N = 8;
		int W = 8;
		int values[] = {1,5,8,9,10,17,17,20};
		int weight[] = {1,2,3,4,5,6,7,8};
		System.out.println(solveDp(values,weight,N,W));
	}
	
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
					t[i][j]=Math.max(values[i-1]+t[i][j-w[i-1]],t[i-1][j]);
				}
				else {
					t[i][j]=t[i-1][j];
				}
			} 
		}
		return t[n][W];
	}
}
