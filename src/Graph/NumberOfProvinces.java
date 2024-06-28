package Graph;
import java.util.*;
public class NumberOfProvinces {

	static boolean[] visited;
	public static void main(String args[]) {
		int[][] adj= {{1,0,0},{0,1,0},{0,0,1}};
		visited=new boolean[adj.length+1];
		System.out.print(solve(adj));
	}
	
	public static int solve(int[][] adj) {
		int count=0;
		for(int i=1;i<visited.length;i++) {
			if(visited[i]!=true) {
				count++;
				dfs(adj,i);
			}
		}
		return count;
	}
	public static void dfs(int[][] adj,int node) {
		visited[node]=true;
		
		for(int i=1;i<=adj[0].length;i++) {
			int isConnected=adj[node-1][i-1];
			if(visited[i]!=true && isConnected==1) {
				dfs(adj,i);
			}
		}
		
	}
}
