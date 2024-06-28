package Graph;
import java.util.*;

public class ReorderPathsLeadingToRoot {

	static int count;
	static boolean[] isVisited;
	public static void main(String args[]) {
//		int n = 6;
//		int [][]connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
		int n = 5;
		int[][] connections = {{1,0},{1,2},{3,2},{3,4}};
		List<List<Integer>> und_adj=new ArrayList<>();
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
			und_adj.add(new ArrayList<>());
		}
		
		for(int[] edge:connections) {
			und_adj.get(edge[0]).add(edge[1]);
			und_adj.get(edge[1]).add(edge[0]);
			adj.get(edge[0]).add(edge[1]);
		}
		isVisited=new boolean[n];
		dfs(und_adj,adj,0);
		System.out.print(count);
	}
	
	public static void dfs(List<List<Integer>> und_adj,List<List<Integer>> adj,int node) {
		isVisited[node]=true;
		
		for(int adjNode:und_adj.get(node)) {
			if(!isVisited[adjNode]) {
				if(adj.get(node).contains(adjNode)) count+=1;
				dfs(und_adj,adj,adjNode);
			}
		}
	}
}
