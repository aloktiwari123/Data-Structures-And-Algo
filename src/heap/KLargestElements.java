package heap;

import java.util.PriorityQueue;

public class KLargestElements {

	public static void main(String args[]) {
		int[] arr= {7,10,4,3,20,15};
		int k=3;
		solve(arr,k);
	}
	
	public static void solve(int[] arr,int k) {
//		PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer>pq=new PriorityQueue<>();
		for(int i:arr) {
			pq.add(i);
			while(pq.size()>k) {
				pq.poll();
			}
		}
		while(pq.size()>0) {
			System.out.println(pq.poll());
		}
	}

}
