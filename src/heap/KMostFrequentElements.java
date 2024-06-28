package heap;
import java.util.*;
public class KMostFrequentElements {
	
	public static void main(String args[]) {
		int[] arr= {1,1,1,2,2,3};
		System.out.print(Arrays.toString(solve_AV(arr,2)));
	}
	
	public static int[] solve(int[] arr, int k) {
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i:arr) {
			map.put(i,map.getOrDefault(i,0)+1);
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
		for(Map.Entry<Integer,Integer> entryKey:map.entrySet()) {
			pq.add(new int[] {entryKey.getValue(),entryKey.getKey()});
		}
		int[] res=new int[k];
		while(k>0) {
			res[--k]=pq.poll()[1];
		}
		return res;
		
	}
	
	public static int[] solve_AV(int[] arr, int k) {
		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i:arr) {
			map.put(i,map.getOrDefault(i,0)+1);
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
		for(Map.Entry<Integer,Integer> entryKey:map.entrySet()) {
			pq.add(new int[] {entryKey.getValue(),entryKey.getKey()});
			while(pq.size()>k) {
				pq.poll();
			}
		}
		int[] res=new int[k];
		while(pq.size()>0) {
			res[--k]=pq.poll()[1];
		}
		return res;
		
	}

}
