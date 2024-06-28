package Graph;

import java.util.*;

public class MaximumTotalImportanceofRoads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int [][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
		int [] val=new int[5];
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int[] edge:roads) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[1]-a[1]));
		for(int i=0;i<n;i++) {
			pq.add(new int[] {i,adj.get(i).size()});
		}
		while(!pq.isEmpty()) {
			int[] temp=pq.poll();
			val[temp[0]]=n;
			n--;
		}
		int score=0;
		for(int[] edge:roads) {
			score+=val[edge[0]]+val[edge[1]];
		}
		System.out.print(score);
	}

}
