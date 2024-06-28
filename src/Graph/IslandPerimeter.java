package Graph;

public class IslandPerimeter {
	static boolean visited[][];
	public static void main(String args[]) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.print(solve(grid));
	}
	
	public static int solve(int[][] grid) {
		int n=grid.length;
		int m=grid[0].length;
		int perimeter=0;
		visited=new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1) {
					perimeter+=dfs(grid,i,j);
				}
			}
		}
		return perimeter;
	}

	private static int dfs(int[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) {
			return 1;
		}
		if(visited[i][j]) {
			return 0;
		}
		visited[i][j]=true;
		int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
		int sum=0;
		for(int[] adj:dir) {
			int newX=i+adj[0];
			int newY=j+adj[1];
			sum+=dfs(grid,newX,newY);
		}
		return sum;

	}
	

}
