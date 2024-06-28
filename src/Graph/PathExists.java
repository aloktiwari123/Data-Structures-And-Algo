package Graph;
import java.util.*;
public class PathExists {
	
	static boolean[] visited;
	public static void main(String args[]) {
		int [][] edges = {{0,1},{1,2},{2,0}};
		int n=3;
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int[] arr:edges) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}
		int source = 0;
		int destination = 2;
		visited=new boolean[n];
		System.out.print(dfs(adj,source,destination));
	}
	
	public static boolean dfs(List<List<Integer>>adj,int node,int destination) {
		if(node==destination) {
			return true;
		}
		visited[node]=true;
		for(int adjNode:adj.get(node)) {
			if(!visited[adjNode]) {
				if(dfs(adj,adjNode,destination)) {
					return true;
				}
			}
		}
		return false;
		
	}

}
