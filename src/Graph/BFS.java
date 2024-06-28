package Graph;
import java.util.*;
public class BFS {
	
	public static void main(String args[]) {
		
		//Adjacency ArrayList 
		// 1-2,1-3,3-4,2-4,2-5,4-5
		int n=4;
		//int m=9;
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<=n;i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        System.out.println(adj);
		System.out.println(solveBFS(n,adj));
		
	}
	
	public static List<Integer> solveBFS(int n,List<List<Integer>>adj)
	{
		Queue<Integer>queue=new LinkedList<>();
		boolean[] visited=new boolean[n+1];
		visited[0]=true;
		queue.add(0);
		List<Integer>list=new ArrayList<>();
		while(!queue.isEmpty()) {
			int val=queue.poll();
			list.add(val);
			for(int i:adj.get(val)) {
				if(visited[i]!=true) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		return list;
	}
	
	

}
