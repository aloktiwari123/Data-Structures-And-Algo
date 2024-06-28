package heap;

import java.util.*;

public class KMostFrequentWord {
	public static void main(String args[]) {
		String [] arr= {"the","day","is","sunny","the","the","the","sunny","is","is"};
		System.out.print(solve(arr,4));
	}
	
	public static List<String> solve(String[] arr,int k) {
		HashMap<String,Integer>map=new HashMap<>();
		for(String i:arr) {
			map.put(i,map.getOrDefault(i,0)+1);
		}
		PriorityQueue<data> pq=new PriorityQueue<>((p1,p2)->{
            if(p1.val==p2.val)return p1.s.compareTo(p2.s);
            else return p2.val-p1.val;});
		for(Map.Entry<String,Integer> entryKey:map.entrySet()) {
			pq.add(new data(entryKey.getKey(),entryKey.getValue()));
		}
		List<String>list=new ArrayList<>();
		while(k>0) {
			list.add(pq.poll().s);
			k-=1;
		}
		return list;
	}

}

class data{
	String s;
	int val;
	
	data(String s,int val){
		this.val=val;
		this.s=s;
	}
}

