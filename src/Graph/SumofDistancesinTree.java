package Graph;
import java.util.*;
public class SumofDistancesinTree {
	
	static int[] count;
	static int[] res;
 	public static void main(String args[]) {
		int n = 6;
		int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		count=new int[n];
		res=new int[n];
		Arrays.fill(count,1);
		for(int[] edge:edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		System.out.print(adj);
		
		depth(adj,0,-1);
		System.out.print(Arrays.toString(count));
		System.out.print(Arrays.toString(res));
	}
	
	public static void depth(List<List<Integer>>adj,int node,int parent) {
		for(int adjNode:adj.get(node)) {
			if(adjNode !=parent) {
				depth(adj,adjNode,node);
				 count[node] += count[adjNode];
	             res[node] += res[adjNode] + count[adjNode];
			}
		}
	}

}
