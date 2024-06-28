package Graph;
import java.util.*;
public class CountCompleteComponents {

	static boolean[] isVisited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int[] edge:edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		isVisited=new boolean[n];
		int count=0;
		
		for(int i=0;i<n;i++) {
			
			if(!isVisited[i]) {
				HashSet<Integer>vertices=new HashSet<>();
				dfs(adj,i,vertices);
				if(isComplete(adj,vertices)) {
					count++;
				}
			}
		}
		System.out.print(count);
		
	}
	
	public static void dfs(List<List<Integer>>adj,int node,HashSet<Integer>vertices) {
		isVisited[node]=true;
		vertices.add(node);
		for(int adjNode:adj.get(node)) {
			if(!isVisited[adjNode]) {
				dfs(adj,adjNode,vertices);
			}
		}
	}
	
	public static boolean isComplete(List<List<Integer>> adj, Set<Integer> vertices) {
	      int n = vertices.size();
	      int countEdges = 0;
	      for (int v : vertices) {
	        countEdges += adj.get(v).size();
	      }

	      int edges = countEdges/2;
	      return (edges == n * (n-1) / 2);
	}

}
