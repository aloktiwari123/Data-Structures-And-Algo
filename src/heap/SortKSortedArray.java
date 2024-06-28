package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

	public class SortKSortedArray {
	public static void main(String args[]) {
		int[] arr= {6,5,3,2,8,10,9};
		int k=3;
		solve(arr,k);
		System.out.print(Arrays.toString(arr));
	}
	
	public static void solve(int[] arr,int k) {
		int c=0;
		PriorityQueue<Integer>pq=new PriorityQueue<>();
		for(int i:arr) {
			pq.add(i);
			while(pq.size()>k) {
				arr[c]=pq.poll();
				c++;
			}
		}
		while(pq.size()>0) {
			arr[c]=pq.poll();
			c++;
		}
	}

}
