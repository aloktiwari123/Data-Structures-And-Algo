package heap;
import java.util.*;
public class KthSmallest {
	
	public static void main(String args[]) {
		int[] arr= {7,10,4,3,20,15};
		int k=3;
		System.out.print(solve(arr,k));
	}
	
	public static int solve(int[] arr,int k) {
//		PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
		for(int i:arr) {
			pq.add(i);
			while(pq.size()>k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
}
