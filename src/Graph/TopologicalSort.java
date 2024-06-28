package Graph;
import java.util.*;
public class TopologicalSort {

	static boolean[] visited;
	public static void main(String args[]) {
		int V = 6;
		visited=new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        System.out.print(topoSort(adj));
	}
	
	public static List<Integer> topoSort(List<List<Integer>>adj){
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<adj.size();i++) {
			if(!visited[i]) {
				dfs(adj,i,st);
			}
		}
		List<Integer>list=new ArrayList<>();
		System.out.print(st);
		while(!st.isEmpty()) {
			list.add(st.pop());
		}
		return list;
	}
	
	public static void dfs(List<List<Integer>>adj,int node,Stack<Integer>st) {
		visited[node]=true;
		for(int adjNode:adj.get(node)) {
			if(!visited[adjNode]) {
				dfs(adj,adjNode,st);
			}
		}
		st.add(node);
	}
}
