package heap;
import java.util.*;
public class KClosestPointToOrigin {
	public static void main(String args[]) {
		int[][] arr= {{3,3},{5,-1},{-2,4}};
		int k=2;
		System.out.print(Arrays.toString(solve(arr,k)));
	}
	
	public static int[][] solve(int[][] arr,int k) {
		PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
		for(int i=0;i<arr.length;i++) {
			int dis=(int) (Math.pow(arr[i][0], 2)+Math.pow(arr[i][1],2));
			pq.add(new int[] {dis,i});
			while(pq.size()>k) {
				pq.poll();
			}
		}
		int[][]res=new int[k][2];
		while(pq.size()!=0) {
			res[--k]=arr[pq.peek()[1]];
			pq.poll();
		}
		return res ;
	}

}
