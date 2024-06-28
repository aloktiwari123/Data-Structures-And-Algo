package Graph;
import java.util.*;
public class MHT {

	static boolean[] isVisited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 int n = 4;
//		 int[][] edges = {{1,0},{1,2},{1,3}};
		 int n = 6;
		 int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
		 isVisited=new boolean[n];
		 List<List<Integer>>adj=new ArrayList<>();
		 for(int i=0;i<n;i++) {
			 adj.add(new ArrayList<>());
		 }
		 for(int[] edge:edges) {
			 adj.get(edge[0]).add(edge[1]);
			 adj.get(edge[1]).add(edge[0]);
		 }
		 int[] ans=new int[n];
		 int min=Integer.MAX_VALUE;
		 for(int i=0;i<n;i++) {
			 isVisited=new boolean[n];
			 ans[i]=solveBFS(adj,i);
			 min=Math.min(min, ans[i]);
		 }
		 List<Integer> list=new ArrayList<>();
		 for(int i=0;i<n;i++) {
			 if(ans[i]==min) {
				 list.add(i);
			 }
		 }
		 System.out.print(list);
	}
	
	public static int solveBFS(List<List<Integer>>adj,int n)
	{
		int count=0;
		Queue<int[]>queue=new LinkedList<>();
		isVisited[n]=true;
		queue.add(new int[] {n,0});
		while(!queue.isEmpty()) {
			int val[]=queue.poll();
			int depth=val[1];
			for(int i:adj.get(val[0])) {
				if(isVisited[i]!=true) {
					queue.add(new int[] {i,depth+1});
					isVisited[i]=true;
				}
			}
			count=depth;
		}
		return count;
	}
	

}
