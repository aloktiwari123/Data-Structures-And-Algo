package Graph;

import java.util.*;

public class BellmanFordAlgorithm {
	
	public static void main(String args[]) {
		int V = 6; 
		int[][]E = {{3, 2, 6},{5, 3, 1},{0, 1, 5},{1, 5, -3},{1, 2, -2},{3, 4, -2},{2, 4, 3}}; 
		int S = 0;
		System.out.print(Arrays.toString(solve(E,S,V)));
	}
	
	public static int[] solve(int[][]adj,int src,int V) {
		int[] dis=new int[V];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[src]=0;
		// n-1 times
		for(int i=0;i<V-1;i++) {
			for(int[] adjNode:adj) {
				int u=adjNode[0];
				int v=adjNode[1];
				int wt=adjNode[2];
				
				if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]) {
					dis[v]=dis[u]+wt;
				}
			}
		}
		
		//nth time to check for cycle
		for(int[] adjNode:adj) {
			int u=adjNode[0];
			int v=adjNode[1];
			int wt=adjNode[2];
			
			if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]) {
				return new int[]{-1};
			}
		}
		
		return dis;
	}
	
	

}
