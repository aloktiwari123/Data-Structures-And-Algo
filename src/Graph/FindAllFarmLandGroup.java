package Graph;
import java.util.*;
public class FindAllFarmLandGroup {
	
	static boolean[][] visited;
	static int maxX,maxY;
	public static void main(String args[]) {
		int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
		System.out.print(solve(land));
	}
	
	public static int[][] solve (int[][] land) {
		List<int[]> list=new ArrayList<>();
		int n=land.length;
		int m=land[0].length;
		visited=new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(land[i][j]==1 && !visited[i][j]) {
					int[] farmland = {i, j, i, j};
					maxX=i;
					maxY=j;
					dfs(land,i,j);
					farmland[2]=maxX;
					farmland[3]=maxY;
					list.add(farmland);
				}
			}
			
		}
		return list.toArray(new int[list.size()][]);
	}

	private static void dfs(int[][] land, int i, int j) {
		// TODO Auto-generated method stub
		if(i<0 || i>= land.length || j<0 || j>= land[0].length || land[i][j] == 0 || visited[i][j]) {
			return;
		}
		visited[i][j]=true;
		maxX=Math.max(i,maxX);
		maxY=Math.max(j,maxY);
		int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
		for(int[] adj:dir) {
			int newX=i+adj[0];
			int newY=j+adj[1];
			dfs(land,newX,newY);
		}
	}
}
