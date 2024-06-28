package Graph;
import java.util.*;
public class ShortestPathInUndirectedGraph {

	public static void main(String args[]) {
		int n = 9;
		int m = 10;
		int [][]edges = {{0,1},{0,3},{3,4},{4 ,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};
		int src=0; 
		System.out.print(Arrays.toString(getShortestPath(n,m,edges,src)));
	}
	
	public static int[] getShortestPath(int n,int m,int [][]edges,int src) {
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<m;i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		Queue<Integer>queue=new LinkedList<>();
		queue.add(src);
		dist[src]=0;
		while(!queue.isEmpty()) {
			int node=queue.poll();
			for(int adjNode:adj.get(node)) {
				if(dist[node]+1<dist[adjNode]) {
					dist[adjNode]=dist[node]+1;
					queue.add(adjNode);
				}
			}
		}
		return dist;
	}
}
