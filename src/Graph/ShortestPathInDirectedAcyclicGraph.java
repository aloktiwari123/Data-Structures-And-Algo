package Graph;
import java.util.*;
public class ShortestPathInDirectedAcyclicGraph {

	static Stack<Integer> st=new Stack<>();
	static boolean[] isVisited;
	public static void main(String args[]) {
		int n = 6, m = 7;
	    int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
	    int res[] = shortestPath(n, m, edge);
	    for (int i = 0; i < n; i++) {
	      System.out.print(res[i] + " ");
	    }
	    System.out.println();
	}
	
	public static int[] shortestPath(int n,int m,int [][]edge) {
		List<List<data>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<data>());
		}
		for(int i=0;i<m;i++) {
			int u=edge[i][0];
			int v=edge[i][1];
			int wt=edge[i][2];
			adj.get(u).add(new data(v,wt));
		}
		isVisited=new boolean[n];
		for(int i=0;i<n;i++) {
			if(!isVisited[i]) {
				topoSort(adj,i);
			}
		}
		//System.out.println(adj);
		//System.out.print(st);
		
		int[] dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		
		while(!st.isEmpty()) {
			int top=st.pop();
			
			for(int i=0;i<adj.get(top).size();i++) {
				int v=adj.get(top).get(i).node;
				int wt=adj.get(top).get(i).wt;
				
				if(dist[top]+wt<dist[v]) {
					dist[v]=dist[top]+wt;
				}
			}
		}
		return dist;
	}

	private static void topoSort(List<List<data>> adj, int i) {
		isVisited[i]=true;
		
		for(data adjNode:adj.get(i)) {
			if(!isVisited[adjNode.node]) {
				topoSort(adj,adjNode.node);
			}
		}
		st.add(i);
	}
}

class data{
	@Override
	public String toString() {
		return "data [node=" + node + ", wt=" + wt + "]";
	}

	int node;
	int wt;
	
	data(int node,int wt){
		this.node=node;
		this.wt=wt;
	}
}
