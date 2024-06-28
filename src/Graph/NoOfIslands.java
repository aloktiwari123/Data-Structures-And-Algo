package Graph;
import java.util.*;
public class NoOfIslands {
	
	static boolean[][] visited; 
	public static void main(String args[]) {
		char grid[][]= {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		visited=new boolean[grid.length][grid[0].length];
		System.out.println(solve(grid));
	}
	
	public static int solve(char grid[][]) {
		int count=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1' && visited[i][j]!=true) {
					count++;
					bfs(grid,new point(i,j));
					
				}
				
			}
		}
	return count;
	}
	
	public static void bfs(char grid[][],point p) {
		Queue<point>queue=new LinkedList<>();
		visited[p.x][p.y]=true;
		queue.add(p);
		
		while(!queue.isEmpty()) {
			p=queue.poll();
			int x=p.x;
			int y=p.y;
			if(x+1<grid.length && grid[x+1][y]=='1' && visited[x+1][y]!=true) {
				queue.add(new point(x+1,y));
				visited[x+1][y]=true;
			}
			if(x-1>=0 && grid[x+1][y]=='1' && visited[x-1][y]!=true ) {
				queue.add(new point(x-1,y));
				visited[x-1][y]=true;
			}
			if(y+1<grid[0].length && grid[x][y+1]=='1' && visited[x][y+1]!=true) {
				queue.add(new point(x,y+1));
				visited[x][y+1]=true;
			}
			if(y-1>=0 && grid[x][y-1]=='1' && visited[x][y-1]!=true) {
				queue.add(new point(x,y-1));
				visited[x][y-1]=true;
			}
		}
		
		
	}
}

class point{


	int x;
	int y;
	
	point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
}
