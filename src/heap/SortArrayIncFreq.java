package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayIncFreq {
	public static void main(String args[]) {
		int[] arr= {-1,1,-6,4,5,-6,1,4,1};
		solve(arr);
		System.out.print(Arrays.toString(arr));
	}
	
	public static void solve(int[] arr) {
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i:arr) {
			map.put(i,map.getOrDefault(i,0)+1);
		}
		//(a[0]==b[0]?a[0]-b[0]:b[1]-a[1]))
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]==b[0]?a[0]-b[0]:b[1]-a[1]));
		for(Map.Entry<Integer,Integer> entryKey:map.entrySet()) {
			pq.add(new int[] {entryKey.getValue(),entryKey.getKey()});
		}
		int c=0;
		while(pq.size()!=0) {
			int val=pq.peek()[1];
			int k=pq.peek()[0];
			int cnt=0;
			while(cnt<k) {
				arr[c++]=val;
				cnt++;
			}
			pq.poll();
		}
	}

}
