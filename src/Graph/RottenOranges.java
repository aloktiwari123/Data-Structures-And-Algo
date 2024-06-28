package Graph;
import java.util.*;
public class RottenOranges {

	static int [][] rotten;
	public static void main(String args[]) {
		int[][] grid =  {{0,1,2},{0,1,2},{2,1,1}};
		int n=grid.length;
		int m=grid[0].length;
		rotten=new int[n][m];
		int freshCount=0;
		Queue<Pair>queue=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==2) {
					rotten[i][j]=2;
					queue.add(new Pair(i,j,0));
				}
				else {
					rotten[i][j]=0;
				}
				if(grid[i][j]==1){
					freshCount++;
				}
			}
		}
		
		System.out.print(rottenOranges(grid,queue,freshCount));
		
	}
	
	public static int rottenOranges(int [][] grid,Queue<Pair>queue,int freshCount) {
		int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
		int time=0;
		int count=0;
		while(!queue.isEmpty()) {
			Pair node=queue.poll();
			int x=node.x;
			int y=node.y;
			time=Math.max(time,node.time);
			for(int i=0;i<dir.length;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny] ==1 && rotten[nx][ny]!=2 ) {
					rotten[nx][ny]=2;
					count++;
					queue.add(new Pair(nx,ny,time+1));
				}
			}
			
		}
		
		return freshCount==count?time:-1;
	}
}

class Pair{
	int x;
	int y;
	int time;
	
	Pair(int x,int y,int time){
		this.x=x;
		this.y=y;
		this.time=time;
	}
	
}


