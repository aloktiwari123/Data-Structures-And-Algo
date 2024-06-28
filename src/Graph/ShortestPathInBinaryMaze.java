package Graph;

import java.util.*;

public class ShortestPathInBinaryMaze {
	
	public static void main(String args[]) {
		int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
		System.out.print(shortestPathInBinaryMaze(grid));
	}
	
	public static int shortestPathInBinaryMaze(int[][] maze) {
		if(maze[0][0]==1) {
			return -1;
		}
		Queue<Nodes>queue=new LinkedList<>();
		int[][] dis=new int[maze.length][maze[0].length];
		queue.add(new Nodes(0,0));
		for(int i=0;i<maze.length;i++) {
			Arrays.fill(dis[i],Integer.MAX_VALUE);
		}
		dis[0][0]=1;
		int[][] moves= {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
		while(!queue.isEmpty()) {
			Nodes node=queue.poll();
			int x=node.x;
			int y=node.y;
			for(int i=0;i<moves.length;i++) {
				int newX=x+moves[i][0];
				int newY=y+moves[i][1];
				
				if(newX>=0 && newX<maze.length && newY>=0 && newY<maze[0].length && maze[newX][newY]!=1) {
					if(dis[x][y]+1<dis[newX][newY]) {
						dis[newX][newY]=dis[x][y]+1;
						queue.add(new Nodes(newX,newY));
					}
				}
			}
		}
		return dis[maze.length-1][maze[0].length-1]==Integer.MAX_VALUE?-1:dis[maze.length-1][maze[0].length-1];
	}

}

class Nodes{
	int x;
	int y;
	
	Nodes(int x,int y){
		this.x=x;
		this.y=y;
	}
}
