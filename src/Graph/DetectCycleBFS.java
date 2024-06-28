package Graph;
import java.util.*;
public class DetectCycleBFS {
	
	static boolean[] visited;
	public static void main(String args[]) {
		List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
//        adj.get(1).add(2);
//        adj.get(2).add(1);
//        adj.get(2).add(3);
//        adj.get(3).add(2);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(1).add(3);
        adj.get(3).add(1);
        visited=new boolean [adj.size()];
        System.out.print(bfs(adj,1));
	}
	
	public static boolean bfs(List<List<Integer>> adj,int src) {
		visited[src]=true;
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {src,-1});
		
		while(!queue.isEmpty()) {
			int[] node=queue.poll();
			
			for(int adjNode:adj.get(node[0])) {
				
				if(visited[adjNode]!=true) {
					visited[adjNode]=true;
					queue.add(new int[] {adjNode,node[0]});
				}
				else if(node[1] !=adjNode) // someone has visited but did not came from it 
					 {
					return true;
				}
			}
		}
		return false;	
	}
	
}

