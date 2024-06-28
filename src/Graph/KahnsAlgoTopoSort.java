package Graph;
import java.util.*;
public class KahnsAlgoTopoSort {
	
	static int[] inDegree;
	public static void main(String args[]) {
		int V = 6;
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
		inDegree=new int[adj.size()];
		for(int i=0;i<adj.size();i++) {
			for(int adjNode:adj.get(i)) {
				inDegree[adjNode]++;
			}
		}
		//BFS
		Queue<Integer>queue=new LinkedList<>();
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}
		}
		List<Integer>list=new ArrayList<>();
		while(!queue.isEmpty()) {
			int node=queue.poll();
			list.add(node);
			for(int adjNode:adj.get(node)) {
				inDegree[adjNode]-=1;
				if(inDegree[adjNode]==0) {
					queue.add(adjNode);
				}
			}
		}
		return list;
	}
}
