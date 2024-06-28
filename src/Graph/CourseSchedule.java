package Graph;
import java.util.*;
public class CourseSchedule {

	static int[] inDegree;
	public static void main(String args[]) {
		int [][]prerequisites = {{1,0},{0,1}};
		int courses=2;
		inDegree=new int[courses];
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<courses;i++) {
			adj.add(new ArrayList<>());
		}
		for(int j=0;j<prerequisites.length;j++) {
			adj.get(prerequisites[j][1]).add(prerequisites[j][0]);
		}
		for(int i=0;i<adj.size();i++) {
			for(int adjNode:adj.get(i)) {
				inDegree[adjNode]++;
			}
		}
		System.out.print(topoSort(adj,courses));
		System.out.print(Arrays.toString(topoSortList(adj,courses)));
	}
	
	public static boolean topoSort(List<List<Integer>>adj,int courses) {
		
		Queue<Integer>queue=new LinkedList<>();
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}
		}
		List<Integer>list=new ArrayList<>();
		while(!queue.isEmpty()) {
			int node=queue.poll();
			list.add(node);
			for(int adjNode:adj.get(node)) {
				inDegree[adjNode]-=1;
				if(inDegree[adjNode]==0) {
					queue.add(adjNode);
				}
			}
		}
		
		return list.size()==courses?true:false;
	}
	
	public static int[] topoSortList(List<List<Integer>>adj,int courses) {
		
		Queue<Integer>queue=new LinkedList<>();
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}
		}
		int[] arr=new int[courses];
		int c=0;
		while(!queue.isEmpty()) {
			int node=queue.poll();
			arr[c++]=node;
			for(int adjNode:adj.get(node)) {
				inDegree[adjNode]-=1;
				if(inDegree[adjNode]==0) {
					queue.add(adjNode);
				}
			}
		}
		if (c == courses) return arr;
        int[] arr1 = {};
		return arr1;
	}
}
