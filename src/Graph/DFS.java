package Graph;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {
	static boolean[] visited=new boolean[5];
	public static void main(String args[]) {
		
		//Adjacency ArrayList 
		// 1-2,1-3,3-4,2-4,2-5,4-5
		int n=4;
		//int m=9;
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<=n;i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        
       List<Integer>list=new ArrayList<>();
       solveDFS(adj,0,list);
       System.out.println(list);
		
	}

	private static void solveDFS(List<List<Integer>> adj,int node,List<Integer>list) {
		visited[node]=true;
		list.add(node);
		
		for(int i:adj.get(node)) {
			if(visited[i]!=true) {
				solveDFS(adj,i,list);
			}
		}
	}

}
