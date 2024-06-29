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
			List<Integer>adjList=new ArrayList<>();
			Set<Integer> set=new HashSet<>();
			findAncestor(adj,i,set);
			for(int j=0;j<n;j++) {
				if(j==i) continue;
				if(set.contains(j))adjList.add(j);
			}
			res.add(adjList);
		}
		System.out.print(res);
	}
	
	public static void findAncestor(List<List<Integer>>adj,int src,Set<Integer> set) {
		set.add(src);
		for(int adjNode:adj.get(src)) {
			if(!set.contains(adjNode)) {
				findAncestor(adj,adjNode,set);
			}
		}
	}

}
