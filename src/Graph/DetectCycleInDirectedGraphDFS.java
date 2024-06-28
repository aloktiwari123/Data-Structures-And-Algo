package Graph;
import java.util.*;
public class DetectCycleInDirectedGraphDFS {
	
	static boolean[] visited;
	static boolean[] pathVisited;
	public static void main(String args[]) {
		int V = 10;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <=V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        
        System.out.print(detectCycle(adj,V));
	}
	
	public static boolean detectCycle(List<List<Integer>> adj,int V) {
		visited=new boolean[V+1];
		pathVisited=new boolean[V+1];
		
		for(int i=1;i<=V;i++) {
			if(!visited[i]) {
				if(dfs(adj,i)==true) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean dfs(List<List<Integer>> adj,int node) {
		visited[node]=true;
		pathVisited[node]=true;
		
		for(int adjNode:adj.get(node)) {
			if(!visited[adjNode]) {
				if(dfs(adj,adjNode)) {
					return true;
				}
			}
			else if(pathVisited[adjNode]) {
				return true;
			}
		}
		pathVisited[node]=false;
		return false;
	}

}
