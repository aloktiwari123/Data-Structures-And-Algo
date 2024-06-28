package Graph;
import java.util.*;
public class PathWithMinEffort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
		System.out.print(solve(heights));
	}
	
	public static int solve(int[][] maze) {
		PriorityQueue<Value>pq=new PriorityQueue<>((a,b)->(a.diff-b.diff));
		pq.add(new Value(0,0,0));
		int[][] dis=new int[maze.length][maze[0].length];
		for(int i=0;i<maze.length;i++) {
			Arrays.fill(dis[i],Integer.MAX_VALUE);
		}
		dis[0][0]=0;
		int[][] moves= {{0,1},{1,0},{0,-1},{-1,0}};
		while(!pq.isEmpty()) {
			Value node=pq.poll();
			int x=node.x;
			int y=node.y;
			int diff=node.diff;
			//if(x == maze.length-1 && y== maze[0].length-1) return diff; 
			for(int i=0;i<moves.length;i++) {
				int newX=x+moves[i][0];
				int newY=y+moves[i][1];
				if(newX>=0 && newX<maze.length && newY>=0 && newY<maze[0].length) {
					int newEffort = Math.max(Math.abs(maze[x][y] - maze[newX][newY]), diff); 
	                if(newEffort < dis[newX][newY]) {
	                	dis[newX][newY] = newEffort; 
	                    pq.add(new Value(newEffort, newX, newY)); 
	                }
					}
				}
		}
		return dis[maze.length-1][maze[0].length-1];
	}

}

class Value{
	int diff;
	int x;
	int y;
	
	Value(int diff,int x,int y){
		this.diff=diff;
		this.x=x;
		this.y=y;
	}
}
