package Graph;
import java.util.*;
public class KosarajuSCCAlgo {
	
	static boolean [] visited;
	public static void main(String args[]) {
		int n = 5;
        int[][] edges = {
            {1, 0}, {0, 2},
            {2, 1}, {0, 3},
            {3, 4}
        };
        visited=new boolean[5];
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> adjRev=new ArrayList<>();
        for(int i=0;i<n;i++) {
        	adj.add(new ArrayList<>());
        	adjRev.add(new ArrayList<>());
        }
        for(int[] edge:edges) {
        	adj.get(edge[0]).add(edge[1]);
        	adjRev.get(edge[1]).add(edge[0]);
        }
        
        System.out.print(kosaraju(adj,adjRev,n));
        
	}
	
	public static int kosaraju(List<List<Integer>>adj,List<List<Integer>>adjRev,int V) {
		//maintain stack to put them by the time of finishing
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++) {
        	if(!visited[i]) {
        		dfs(adj,i,st);
        	}
        }
        System.out.print(st);
        visited=new boolean[V];
        int sccs=0;
        while(!st.isEmpty()) {
        	int top=st.pop();
        	if(!visited[top]) {
        		sccs++;
        		dfsTraverse(adjRev,top);
        	}
        }
		return sccs;
	}
	public static void dfs(List<List<Integer>>adj,int node,Stack<Integer> st) {
		visited[node]=true;
		
		for(Integer adjNode:adj.get(node)) {
			if(!visited[adjNode]) {
				dfs(adj,adjNode,st);
			}
		}
		st.push(node);
	}
	
	public static void dfsTraverse(List<List<Integer>>adj,int node) {
		visited[node]=true;
		
		for(Integer adjNode:adj.get(node)) {
			if(!visited[adjNode]) {
				dfsTraverse(adj,adjNode);
			}
		}
		
	}

}
