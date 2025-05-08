package Graph;
import java.util.*;
public class SmallestNoOfNeighbours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 4;
		 int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		 int distanceThreshold = 4;
		 List<List<Pair>>adj=new ArrayList<>();
		 for(int i=0;i<n;i++) {
			 adj.add(new ArrayList<>());
		 }
		 for(int[] edge:edges) {
			 adj.get(edge[0]).add(new Pair(edge[0],edge[1],edge[2]));
			 adj.get(edge[1]).add(new Pair(edge[1],edge[0],edge[2]));
		 }
		 int[][]dis=shortestDistance(adj,n);
		 PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
				 if(a[1]==b[1]) {
					 return b[0]-a[0];
				 }
				 return a[1]-b[1];
		 });
		 for(int i=0;i<n;i++) {
			 int[] node=new int[] {i,0};
			 for(int j=0;j<n;j++) {
				 if(dis[i][j]<=distanceThreshold) {
					 node[1]++;
				 }
			 }
			 pq.add(node);
		 }
		 System.out.print(pq.peek()[0]);
		 
	}
	
	public static int[][] shortestDistance(List<List<Pair>>adj,int n){
		int[][] dis=new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(dis[i],Integer.MAX_VALUE);
		}
		for(int i=0;i<n;i++) {
			dis[i][i]=0;
			for(Pair node:adj.get(i)) {
				dis[i][node.y]=node.time;
			}
		}
		
		// via approach brute force
		for(int via=0;via<n;via++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(dis[i][via]!=Integer.MAX_VALUE && dis[via][j]!=Integer.MAX_VALUE) {
						dis[i][j]=Math.min(dis[i][j],dis[i][via]+dis[via][j]);
					}
				}
			}
		}
		
		return dis;
	}

}
