package Graph;
import java.util.*;

// Tarjans Algorithm
public class FindBridges {
    static int timmer=1;
    static List<List<Integer>> bridges=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
        int[][] edges = {
            {0, 1}, {1, 2},
            {2, 0}, {1, 3}
        };
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges) {
        	adj.get(edge[0]).add(edge[1]);
        	adj.get(edge[1]).add(edge[0]);
        }
        solve(adj,n);
	}

	public static List<List<Integer>> solve(List<List<Integer>> adj,int V) {
		int[] low = new int[V];
        int[] tin = new int[V];
        boolean[] vis =new boolean [V];
        Arrays.fill(vis, false);
        dfs(adj,0,-1,vis,tin,low);
        System.out.print(bridges);
        return bridges;
	}
	
	public static void dfs(List<List<Integer>> adj,int node,int par,boolean[] vis,int[] tin,int[] low) {
		vis[node]=true;
		tin[node]=low[node]=timmer;
		timmer++;
		
		for(int adjNode:adj.get(node)) {
			if(adjNode == par) continue;
			if(!vis[adjNode]) {
				dfs(adj,adjNode,node,vis,tin,low);
				low[node]=Math.min(low[node],low[adjNode]);
				
				// bridge check 
				// if there is any other way we can reach back to parent or prior to the parent
				if(low[adjNode]>tin[node]) {
					bridges.add(new ArrayList() {{add(adjNode);add(node);}});
				}
			}
			else {
				low[node]=Math.min(low[adjNode],low[node]);
			}
		}
	}
}
