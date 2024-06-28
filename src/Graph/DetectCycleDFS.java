package Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDFS {

	static boolean[] visited;
	public static void main(String args[]) {
		List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        
//        adj.get(1).add(2);
//        adj.get(2).add(1);
//        adj.get(2).add(3);
//        adj.get(3).add(2);
        
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        visited=new boolean [adj.size()];
        System.out.print(dfs(adj,1,-1));
	}
	
	// for connected components
	
	public static boolean detectCycle(List<List<Integer>> adj) {
		for (int i = 1; i <= 3; i++) {
            if(!visited[i]) {
            	if(dfs(adj,i,-1)==true) {
            		return true;
            	}
            }
        }
		return false;
		
	}
	
	public static boolean dfs(List<List<Integer>> adj, int node,int parent) {
		// TODO Auto-generated method stub
		visited[node]=true;
		for(int adjNode:adj.get(node)) {
			if(!visited[adjNode]) {
				if(dfs(adj,adjNode,node)==true) {
					return true;
				}
			}
			else if(adjNode != parent) // someone has visited but did not came from it  
				{
				return true;
			}
		}
		return false;
	}
	
//	public static boolean dfs(List<List<Integer>> adj, int node,int parent) {
//		// TODO Auto-generated method stub
//		visited[node]=true;
//		boolean status=false;
//		for(int adjNode:adj.get(node)) {
//			if(!visited[adjNode]) {
//				status=status || dfs(adj,adjNode,node);
//			}
//			else if(adjNode != parent) // someone has visited but did not came from it  
//				{
//				return true;
//			}
//		}
//		return status;
//	}
	
	
}
