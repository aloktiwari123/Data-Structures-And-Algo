package Graph;
import java.util.*;
public class ShortestPathVisitingAll {

	static int[][] weight;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
		floydWarshal(graph);
	}
	
	public static void floydWarshal(int[][]graph) {
		int n=graph.length;
		weight=new int[n][n];
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
					if(weight[i][via]!=Integer.MAX_VALUE  && weight[via][j]!=Integer.MAX_VALUE) {
						weight[i][j]=Math.min(weight[i][j],weight[i][via]+weight[via][j]);
					}
				}
			}
		}
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=i;
		}
		System.out.print(allPermuatation(arr,0));
	}
	
	public static int allPermuatation(int[] arr,int t) {
		int min=Integer.MAX_VALUE;
		if(t==arr.length) {
			return getCost(arr);
		}
		
		for(int i=t;i<arr.length;i++ ) {
			swap(arr,t,i);
			min=Math.min(allPermuatation(arr,t+1),min);
			swap(arr,i,t);
		}
		return min;
	}
	
	public static void swap(int[]arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int getCost(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length-1;i++) {
			sum+=weight[arr[i]][arr[i+1]];
		}
		return sum;
	}

}
