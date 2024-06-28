package heap;

import java.util.PriorityQueue;

public class RemoveDuplicateChar {
	
	public static void main(String args[]) {
		System.out.print(solve("cbacdcbc"));
	}
	
	public static String solve(String s) {
		PriorityQueue<Character>pq=new PriorityQueue<>();
		char[] arr=s.toCharArray();
		
		for(char ch:arr) {
			if(!pq.contains(ch)) {
				pq.add(ch);
			}
		}
		StringBuilder st=new StringBuilder();
		while(!pq.isEmpty()) {
			st.append(pq.poll());
		}
		return st.toString();
	}

}
