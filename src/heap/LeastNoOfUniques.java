package heap;

import java.util.*;

public class LeastNoOfUniques {

	public static void main(String args[]) {
		int[]arr = {4,3,1,1,3,3,2};
		int k = 3;
		System.out.print(solve(arr,k));
	}
	
	public static int solve(int[] arr,int k) {
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i:arr) {
			map.put(i,map.getOrDefault(i,0)+1);
		}
		PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
		
		for(Map.Entry<Integer,Integer> entryKey:map.entrySet()) {
			pq.add(new int[] {entryKey.getValue(),entryKey.getKey()});
		}
		while(k>0) {
			int n=pq.peek()[1];
			map.put(n,map.get(n)-1);
			if(map.get(n)==0) {
				map.remove(n);
				pq.poll();
			}
			k--;
		}
		return map.size();
	}
}
