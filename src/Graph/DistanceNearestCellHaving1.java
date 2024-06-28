package Graph;

import java.util.*;

public class DistanceNearestCellHaving1 {
	
	public static void main(String args[]) {
		int[][] grid= {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
		int[][] res=distanceOfNearest1(grid);
		for(int i=0;i<res.length;i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
	
	public static int[][] distanceOfNearest1(int[][] grid){
		int n=grid.length;
		int m=grid[0].length;
		int dis[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(dis[i],Integer.MAX_VALUE);
		}
		Queue<Nodes>queue=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1) {
					queue.add(new Nodes(i,j));
					dis[i][j]=0;
				}
			}
		}
		int[][] moves= {{0,1},{1,0},{0,-1},{-1,0}};
		while(!queue.isEmpty()) {
			Nodes node=queue.poll();
			int x=node.x;
			int y=node.y;
			for(int move[]:moves) {
				int newX=x+move[0];
				int newY=y+move[1];
				if(newX>=0 && newX<n && newY>=0 && newY<m) {
					if(dis[x][y]+1<dis[newX][newY]) {
						dis[newX][newY]=dis[x][y]+1;
						queue.add(new Nodes(newX,newY));
					}
				}
			}
		}
		return dis;
	}
	
	public static int[][] distanceOfNearest0(int[][] grid){
		int n=grid.length;
		int m=grid[0].length;
		int dis[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(dis[i],Integer.MAX_VALUE);
		}
		Queue<Nodes>queue=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==0) {
					queue.add(new Nodes(i,j));
					dis[i][j]=0;
				}
			}
		}
		int[][] moves= {{0,1},{1,0},{0,-1},{-1,0}};
		while(!queue.isEmpty()) {
			Nodes node=queue.poll();
			int x=node.x;
			int y=node.y;
			for(int move[]:moves) {
				int newX=x+move[0];
				int newY=y+move[1];
				if(newX>=0 && newX<n && newY>=0 && newY<m) {
					if(dis[x][y]+1<dis[newX][newY]) {
						dis[newX][newY]=dis[x][y]+1;
						queue.add(new Nodes(newX,newY));
					}
				}
			}
		}
		return dis;
	}


}
