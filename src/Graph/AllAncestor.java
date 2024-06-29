package Graph;
import java.util.*;
public class AllAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int[][] edgeList = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int[] edge:edgeList) {
			adj.get(edge[1]).add(edge[0]);
		}
		List<List<Integer>>res=new ArrayList<>();
		for(int i=0;i<n;i++) {
			res.add(bfs(adj,i,n));
		}
		//System.out.print(res);
	}
	
	public static List<Integer> bfs(List<List<Integer>>adj,int src,int n){
		boolean[] visited=new boolean[n];
		Queue<Integer>queue=new LinkedList<>();
		queue.add(src);
		visited[src]=true;
		List<Integer>list=new ArrayList<>();
		while(!queue.isEmpty()) {
			int node=queue.poll();
			for(int adjNode:adj.get(node)) {
				if(!visited[adjNode]) {
					if(!list.contains(adjNode)) {
						list.add(adjNode);
					}
					queue.add(adjNode);
				}
			}
		}
		Collections.sort(list);  
		return list;
	}

}
