package heap;
import java.util.*;
public class ReorganiseString {
	public static void main(String args[]) {
		String s="abbabbaaab";
		System.out.print(solve(s));
	}
	
	public static String solve(String s) {
		HashMap<Character,Integer>map=new HashMap<>();
		for(char ch:s.toCharArray()) {
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		PriorityQueue<int[]>pq=new PriorityQueue<>((p,q)->(q[0]-p[0]));
		StringBuilder st=new StringBuilder();
		for(Map.Entry<Character,Integer>entrySet:map.entrySet()) {
			pq.add(new int[] {entrySet.getValue(),entrySet.getKey()});
		}
		while(pq.size()>1) {
			int[] largest=pq.poll();			
			int[] largest2=pq.poll();
			st.append((char)largest[1]);
			st.append((char)largest2[1]);
			largest[0]--;
			largest2[0]--;
			if(largest[0]>0) {
				pq.add(largest);
			}
			if(largest2[0]>0) {
				pq.add(largest2);
			}
		}
		if(!pq.isEmpty()) {
			if(pq.peek()[0]>1) {
				return "";
			}
			else {
				st.append((char)pq.peek()[1]);
			}
		}
		return st.toString();
	}

}
