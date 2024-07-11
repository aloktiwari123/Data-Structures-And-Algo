package Graph;
import java.util.*;
public class FuelCost {

	static boolean[] visited;
	static int[] indegree;
	static int[] peoples;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
		int[][] roads= {{1,0},{0,2},{3,1},{1,4},{5,0}};
		int seats = 1;
		int n=roads.length+1;
		indegree=new int[roads.length+1];
		peoples=new int[roads.length+1];
		visited=new boolean[roads.length+1];
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int[] road:roads) {
			adj.get(road[0]).add(road[1]);
			adj.get(road[1]).add(road[0]);
		}
		//System.out.print(dfs(adj,0,0,2,seats));
		long cost=0;
		for(int i=0;i<adj.size();i++) {
			indegree[i]=adj.get(i).size();
		}
		for(int i=0;i<adj.size();i++) {
			if(adj.get(i).size()==1) {
				cost+=dfs(adj,0,0,i,seats);
			}
		}
		System.out.print(cost);
	}
	
	
	public static long dfs(List<List<Integer>>adj,int people,int des,int src,int seats) {
		if(src==des) {return 0; }
		visited[src]=true;
		long cost=0;
		for(int adjNode:adj.get(src)) {
			if(!visited[adjNode]) {
				peoples[adjNode]++;
				people=peoples[adjNode];
				indegree[adjNode]--;
				long curCost=cost(people,seats);
				cost+=curCost+indegree[adjNode]==1?dfs(adj,people,des,adjNode,seats):1;
			}
		}
		return cost;
	}
	
	public static long cost(int people,int seats ) {
		return people%seats==0?(people/seats):(people/seats)+1;
	}

}
