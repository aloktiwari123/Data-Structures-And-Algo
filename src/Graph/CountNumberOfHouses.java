package Graph;
import java.util.*;
public class CountNumberOfHouses {
	static int[] count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int x = 2;
		int y = 4;
		
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<n-1;i++) {
			adj.get(i).add(i+1);
			adj.get(i+1).add(i);
		}
		adj.get(x-1).add(y-1);
		adj.get(y-1).add(x-1);
		//System.out.print(adj);
		count=new int[n];
		for(int i=0;i<n;i++) {
			int[] dis=solve(adj,i);
			for(int j=0;j<n;j++) {
				if(dis[j]!=0 && dis[j]!=Integer.MAX_VALUE) count[dis[j]-1]++;
			}
		}
		System.out.print(Arrays.toString(count));
	}
	
	public static int[] solve(List<List<Integer>>adj,int src) {
		int [] dis=new int[adj.size()];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[src]=0;
		Queue<Integer>queue=new LinkedList<>();
		queue.add(src);
		while(!queue.isEmpty()) {
			int node=queue.poll();
			for(int adjNode:adj.get(node)) {
				if(dis[node]+1<dis[adjNode]) {
					dis[adjNode]=dis[node]+1;
					queue.add(adjNode);
				}
			}
		}
		return dis;
	}
	

}
