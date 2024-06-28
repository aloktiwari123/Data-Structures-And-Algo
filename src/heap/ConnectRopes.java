package heap;

import java.util.PriorityQueue;
// we need two min elements in the array every time
public class ConnectRopes {
	public static void main(String args[]) {
		int[] arr= {1,2,3,4,5};
		System.out.print(solve(arr));
	}
	
	public static int solve(int[] arr) {
		PriorityQueue<Integer>pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		int res=0;
		while(pq.size()!=1) {
			int sum=pq.poll()+pq.poll();
			res+=sum;
			pq.add(sum);
		}
		return res;
	}

}
