package Graph;
import java.util.*;
public class NetworkDelay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]times = {{2,1,1},{2,3,1},{3,4,1}};
		int n= 4;
		int k = 2;
		List<List<Pairs>>adj=new ArrayList<>();
		for(int i=0;i<=n;i++) {
			adj.add(new ArrayList<Pairs>());
		}
		for(int[] edge:times) {
			adj.get(edge[0]).add(new Pairs(edge[1],edge[2]));
		}
		System.out.print(networkDelay(adj,n,k));
	}
	
	public static int networkDelay(List<List<Pairs>>adj,int n,int k) {
		int []dis=new int[n+1];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[k]=0;
		PriorityQueue<Pairs>pq=new PriorityQueue<>((x,y)->(x.distance-y.distance));
		pq.add(new Pairs(k,0));
		
		while(!pq.isEmpty()) {
			Pairs pair=pq.poll();
			int node=pair.node;
			int dist=pair.distance;
			
			for(Pairs adjNode:adj.get(node)) {
				if(dist+adjNode.distance<dis[adjNode.node]) {
					dis[adjNode.node]=dist+adjNode.distance;
					pq.add(new Pairs(adjNode.node,dis[adjNode.node]));
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(dis[n]==Integer.MAX_VALUE) {
				return -1;
			}
		}
		return dis[n];
	}

}
