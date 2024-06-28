package Graph;
import java.util.*;
public class PrimsAlgo {
	
	static boolean[] isVisited;
	public static void main(String args[]) {
		int V = 5;
        List<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        System.out.print(primsAlgo(adj,V));
	}
	
	public static int primsAlgo(List<ArrayList<ArrayList<Integer>>>adj,int V) {
		isVisited=new boolean[V];
		PriorityQueue<Pairs>pq=new PriorityQueue<>((x,y)->(x.distance-y.distance));
		pq.add(new Pairs(0,0));
		int sum=0;
		
		while(!pq.isEmpty()) {
			Pairs pair=pq.poll();
			int node=pair.node;
			int weight=pair.distance;
			
			if(!isVisited[node]) {
				sum=sum+weight;
				isVisited[node]=true;
				
				for(List<Integer> adjNode:adj.get(node)) {
					int ed=adjNode.get(0);
					int edW=adjNode.get(1);
					if(!isVisited[ed]) {
						pq.add(new Pairs(ed,edW));
					}
				}
			}
		}
		return sum;
	}
}
