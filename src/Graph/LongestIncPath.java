package Graph;

public class LongestIncPath {

	public static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {{9,9,4},{6,6,8},{2,1,1}};
		System.out.print(solve(matrix));
	}
	
	public static int solve(int[][] matrix) {
		if(matrix.length == 0) return 0;
	    int n = matrix.length, m = matrix[0].length;
	    int[][] cache = new int[n][m];
	    int max = 1;
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            int len = dfs(matrix, i, j, n, m, cache);
	            max = Math.max(max, len);
	        }
	    }   
	    return max;
	}
	
	public static int dfs(int[][] matrix,int x,int y,int n,int m,int[][] memo) {
		if(memo[x][y]!=0) return memo[x][y];
		int max=1;
		for(int[] dir:dirs) {
			int newX=x+dir[0];
			int newY=y+dir[1];
			if(newX>=0 && newX<n && newY>=0 && newY<m && matrix[newX][newY]>matrix[x][y]) {
				int len=1+dfs(matrix,newX,newY,n,m,memo);
				max=Math.max(len,max);
			}
		}
		
		memo[x][y]=max;
		return max;
	}
	
	

}
