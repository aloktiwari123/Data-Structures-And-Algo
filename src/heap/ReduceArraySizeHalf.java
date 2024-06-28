package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeHalf {
	public static void main(String args[]) {
		int[] arr= {7,7,7,7,7,7};
		System.out.print(solve(arr));
	}
	
	public static int solve(int[] arr) {
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i:arr) {
			map.put(i,map.getOrDefault(i,0)+1);
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
		for(Map.Entry<Integer,Integer> entryKey:map.entrySet()) {
			pq.add(new int[] {entryKey.getValue(),entryKey.getKey()});
		}
		int half=arr.length/2;
		int sum=0;
		int c=0;
		while(sum<half && !pq.isEmpty()) {
			c+=1;
			int k=pq.peek()[0];
			sum+=k;
			pq.poll();
		}
		return c;
	}
}
