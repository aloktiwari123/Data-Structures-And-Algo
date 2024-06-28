package Graph;
import java.awt.desktop.SystemEventListener;
import java.util.*;
public class ParallelCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] relations = {{1,5},{2,5},{3,5},{3,4},{4,5}};
		int[] time = {1,2,3,4,5};
		System.out.print(solve(relations,time,n));
	
	}
	
	public static int solve(int[][] edges,int[] time,int n) {
		List<List<Integer>>adj=new ArrayList<>();
		int[]maxTime=new int[n];
		for(int i=0;i<n+1;i++) {
			adj.add(new ArrayList<>());
		}
		int[] inDegree=new int[n];
		
		for(int[] edge:edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
			adj.get(x).add(y);
			inDegree[y]++;
		}
		Queue<Integer>queue=new LinkedList<>();
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
				maxTime[i]=time[i];
				
			}
		}
		
		while(!queue.isEmpty()) {
			int node=queue.poll();
			for(int adjNode:adj.get(node)) {
				maxTime[adjNode]=Math.max(maxTime[node]+time[adjNode],maxTime[adjNode]);
				inDegree[adjNode]-=1;
				if(inDegree[adjNode]==0) {
					queue.add(adjNode);
				}
			}
			
		}
		int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, maxTime[node]);
        }
		return ans;
	}

}
