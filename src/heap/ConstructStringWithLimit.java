package heap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithLimit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cczazcc";
		int k = 3;
		System.out.print(construct(s,k));
	}
	
	public static String construct(String s,int k) {
		StringBuilder res=new StringBuilder();
		HashMap<Character,Integer>map=new HashMap<>();
		
		for(char ch:s.toCharArray()) {
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		
		PriorityQueue<Character>pq=new PriorityQueue<>((a,b)->(b-a));
		for(char ch:map.keySet()) {
			pq.add(ch);
		}
		
		while(!pq.isEmpty()) {
			char ch=pq.poll();
			int freq=map.get(ch);
			
			int use=Math.min(freq,k);
			
			for(int i=0;i<use;i++) {
				res.append(ch);
			}
			
			map.put(ch,freq-use);
			
			if(map.get(ch)>0 && !pq.isEmpty()) {
				char nextCh=pq.poll();
				res.append(nextCh);
				map.put(nextCh,map.get(nextCh)-1);
				if(map.get(nextCh)>0) pq.add(nextCh);
				pq.add(ch);
			}
		}
		return res.toString();
	}

}
