package Graph;

import java.util.Arrays;

public class FloydWarshallAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{1,2,3},{0},{0},{0}};
		floydWarshal(graph);
	}
	
	public static void floydWarshal(int[][]graph) {
		int n=graph.length;
		int[][] weight=new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(weight[i],Integer.MAX_VALUE);
		}
		for(int i=0;i<n;i++) {
			weight[i][i]=0;
			for(int temp:graph[i]) {
				weight[i][temp]=1;
			}
		}
		for(int via=0;via<n;via++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					weight[i][j]=Math.min(weight[i][j],weight[i][via]+weight[via][j]);
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(Arrays.toString(weight[i]));
		}
	}
}
