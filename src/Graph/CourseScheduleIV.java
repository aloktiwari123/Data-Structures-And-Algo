package Graph;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV {

	static int[][] isReachable;
	static int[] isVisited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 3;
		int[][] prerequisites = {{1,2},{1,0},{2,1}}; 
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			adj.add(new ArrayList<>());
		}
		for(int[] adjNode:prerequisites) {
			adj.get(adjNode[0]).add(adjNode[1]);
		}
		int[][] queries = {{1,0},{1,2}};
		isReachable=new int[numCourses][numCourses];
		for(int i=0;i<numCourses;i++) {
			isVisited=new int[numCourses];
			dfs(i,i,adj);
		}
		List<Boolean>ans=new ArrayList<>();
		for(int[] query:queries) {
			if(isReachable[query[0]][query[1]]==1) {
				ans.add(true);
			}else {
				ans.add(false);
			}
		}
		System.out.print(ans);
	}
	
	public static void dfs(int startNode,int node,List<List<Integer>>adj) {
		isVisited[node]=1;
		isReachable[startNode][node]=1;
		
		for(int adjNode:adj.get(node)) {
			if(isVisited[adjNode]==0) {
				dfs(startNode,adjNode,adj);
			}
		}
	}
	
	

}
