package heap;

import java.util.PriorityQueue;

public class FinalArrayKMult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] kMultiply(int[] arr,int k,int multiplier) {
		PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
		for(int i=0;i<arr.length;i++) {
			pq.add(new int[] {arr[i],i});
		}
		
		while(k-- > 0) {
			int[] curr= pq.poll();
			arr[curr[1]]=arr[curr[1]]*multiplier;
			pq.add(new int[] {arr[curr[1]],curr[1]});
		}
		
		return arr;
	}

}
