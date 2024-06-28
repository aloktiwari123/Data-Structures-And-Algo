package Graph;
import java.util.*;
public class LoudAndRich {

	static int[] ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
		int[] quiet = {3,2,5,4,6,1,7,0};
		solve(richer,quiet);
		System.out.print(Arrays.toString(ans));
		
	}
	public static void solve(int[][] richer,int[] quiet) {
		ans=new int[quiet.length];
		Arrays.fill(ans,-1);
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<quiet.length;i++) {
			adj.add(new ArrayList<>());
		}
		for(int[] adjNode:richer) {
			adj.get(adjNode[1]).add(adjNode[0]);
		}
		System.out.print(adj);
		for(int i=0;i<quiet.length;i++) {
			dfs(adj,i,quiet);
		}
	}
	
	public static int dfs(List<List<Integer>>adj,int node,int[] quiet) {
		if(ans[node]==-1) {
			ans[node]=node;
			for(int adjNode:adj.get(node)) {
				int rich=dfs(adj,adjNode,quiet);
				if(quiet[rich]<quiet[ans[node]]) {
					ans[node]=rich;
				}
			}
		}
		return ans[node];
	}

}
