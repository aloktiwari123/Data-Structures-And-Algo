package Graph;
import java.util.*;
public class RedundantConnections {

	public static void main(String args[]) {
		int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
		System.out.print(Arrays.toString(findRedundantConnection(edges,edges.length)));
	}
	
	public static int[] findRedundantConnection(int [][] edges,int V) {
		DisjointSet set=new DisjointSet(V);
		int [] ans=new int[2];
		for(int[] edge:edges) {
			int u=edge[0];
			int v=edge[1];
			
			if(set.findUParent(u)!=set.findUParent(v)) {
				set.unionBySize(u, v);
			}
			else {
				ans[0]=u;
				ans[1]=v;
			}
		}
		return ans;
	}
}
