package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharsByFreq {
	public static void main(String args[]) {
		String s="tree";
		char[] arr=s.toCharArray();
		solve(arr);
		System.out.print(new String(arr));
	}
	
	public static void solve(char[] arr) {
		HashMap<Character,Integer>map=new HashMap<>();
		for(char i:arr) {
			map.put(i,map.getOrDefault(i,0)+1);
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
		for(Map.Entry<Character,Integer> entryKey:map.entrySet()) {
			pq.add(new int[] {entryKey.getValue(),entryKey.getKey()});
		}
		int c=0;
		while(pq.size()!=0) {
			int val=pq.peek()[1];
			int k=pq.peek()[0];
			int cnt=0;
			while(cnt<k) {
				arr[c++]=(char)val;
				cnt++;
			}
			pq.poll();
		}
	}

}
