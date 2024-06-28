package Graph;

import java.util.*;

public class BipartiteGraphDFS {
	
	static int[] color;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List < List < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        System.out.print(checkBipartite(adj));
       
	}
	
	public static boolean checkBipartite(List<List<Integer>>adj) {
		color = new int[adj.size()]; 
		
	    Arrays.fill(color,-1);
	    
		for(int i=0;i<adj.size();i++) {
			if(color[i]==-1) {
				if(dfs(adj,0,0)==false) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static boolean dfs(List<List<Integer>>adj,int node,int curColor) {
		color[node]=curColor;
		for(int adjNode:adj.get(node)) {
			if(color[adjNode]==-1) {
				dfs(adj,adjNode,color[node]==0?1:0);
			}
			else if(color[adjNode]==color[node]) {
				return false;
			}
		}
		return true;
	}

}
