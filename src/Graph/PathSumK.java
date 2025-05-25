package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class PathSumK {

	static int maxSum=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 3;
		 int [][]edges = {{0,1,8},{0,2,8},{1,2,9}};
		 int k = 1, t = 511;
		 List<List<int[]>>adj=new ArrayList<>();
		 for(int i=0;i<n;i++) {
			 adj.add(new ArrayList<>());
		 }
		 for(int i=0;i<edges.length;i++) {
		{
			adj.get(edges[i][0]).add(new int[] {edges[i][1],edges[i][2]});
		}
	    }
		int max=-1;
		for(int i=0;i<adj.size();i++) {
			max=Math.max(max,solveDFS(adj,i,k,t,0));
		}
//		List<Integer> res = new ArrayList<>();
//		res.stream().mapToInt(Integer::intValue).toArray();
		System.out.print(max);
	}
	
	private static int solveDFS(List<List<int[]>>adj,int node,int k,int t,int sum) {
		if(k==0) {
			return sum<t?sum:Integer.MAX_VALUE;
		}
		for(int adjNode[]:adj.get(node)) {
			int currAdj=adjNode[0];
			sum+=adjNode[1];
			return solveDFS(adj,currAdj,k-1,t,sum);
		}
		return -1;
	}


}

