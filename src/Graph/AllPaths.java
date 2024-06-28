package Graph;
import java.util.*;

public class AllPaths {

	static List<List<Integer>> list=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] graph = {{1,2},{3},{3},{}};
		int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
		List<Integer> path=new ArrayList() {{add(0);}};
		dfs(graph,0,path);
		System.out.print(list);
	}
	
	public static void dfs(int[][] adj,int node,List<Integer> path) {
		if(node == (adj.length-1))
		{
			list.add(path);
			return;
		}
		
		for(int edge:adj[node]) {
			List<Integer> temp=new ArrayList<>(path);
			temp.add(edge);
			dfs(adj,edge,temp);
		}
		
	}

}
