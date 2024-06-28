package Graph;
import java.util.*;

//notes 
/* TC - E log(V)
 * any graph with negative weights can not implement dijkstra Algo as it will fall in infinte loop
 */
public class DijkstraAlgorithmPriorityQueue {

	public static void main(String args[]) {
	    int V=3,E=3,S=2;
	    int[][][] edges = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
	    List<List<Pairs>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++) {
	    	adj.add(new ArrayList<Pairs>());
	    }
	    for(int i=0;i<edges.length;i++) {
	    	for(int[] temp:edges[i])
	    	{
	    		adj.get(i).add(new Pairs(temp[0],temp[1]));
	    	}
	    }
	    System.out.print(Arrays.toString(dijkstraShortestPath(adj,V,S)));
	    
	}
	
	public static int[] dijkstraShortestPath(List<List<Pairs>>adj,int V,int src) {
		PriorityQueue<Pairs>pq=new PriorityQueue<>((x,y)->(x.distance-y.distance));
		pq.add(new Pairs(src,0));
		int[] dis=new int[V];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[src]=0;
		
		while(!pq.isEmpty()) {
			Pairs pair=pq.poll();
			int node=pair.node;
			int distance=pair.distance;
			
			for(Pairs adjNode:adj.get(node)) {
				if(distance+adjNode.distance<dis[adjNode.node]) {
					dis[adjNode.node]=distance+adjNode.distance;
					pq.add(new Pairs(adjNode.node,dis[adjNode.node]));
				}
			}
		}
		return dis;
		
	}
}

class Pairs{
	int node;
	int distance;
	
	Pairs(int node,int distance){
		this.node=node;
		this.distance=distance;
	}
}
