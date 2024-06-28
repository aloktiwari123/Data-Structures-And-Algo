package BackTracking;

public class PathWithMaximumGold {
	
	public static void main(String args[]) {
		int grid[][]= {{0,6,0},{5,8,7},{0,9,0}};
		int n=grid.length;
		int m=grid[0].length;
		System.out.print(getMaxGold(grid));
	}
	
	public static int dfs(int[][]grid,int x,int y,int n,int m) {
		if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) return 0;
		
		int [][] moves= {{0,1},{0,-1},{1,0},{-1,0}};
		int curr=grid[x][y];
		grid[x][y]=0;
		int max=curr;
		for(int []move:moves) {
			int newX=x+move[0];
			int newY=y+move[1];
			max=Math.max(max,curr+dfs(grid,newX,newY,n,m));
		}
		grid[x][y]=curr;
		return max;
	}
	
    public static int getMaxGold(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxGold=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j, n, m));
                }
            }
        }

        return maxGold;
    }
	

}
