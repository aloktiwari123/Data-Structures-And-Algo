package Graph;

public class MaxFish {

	static int[][] isVisited;
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
		int max=0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]!=0) {
					count=0;
					isVisited=new int[grid.length][grid[0].length];
					dfs(i,j,grid);
					max=Math.max(max,count);
				}
			}
		}
		System.out.print(max);
	}
	
	public static void dfs(int x,int y,int[][]grid) {
		isVisited[x][y]=1;
		count+=grid[x][y];
		
		int[][] dirs= {{0,-1},{0,1},{1,0},{-1,0}};
		
		for(int[] dir:dirs) {
			int newX=x+dir[0];
			int newY=y+dir[1];
			if(isValid(newX,newY,grid)) {
				dfs(newX,newY,grid);
			}
		}
	}

	private static boolean isValid(int x, int y, int[][] grid) {
		// TODO Auto-generated method stub
		return x>=0 && x < grid.length && y>=0 && y < grid[0].length && grid[x][y]!=0 && isVisited[x][y]!=1;
	}

}
