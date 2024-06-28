package Graph;
import java.util.*;

public class HandOfStraights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] hand = {1,2,3,6,2,3,4,7,8};
		int groupSize = 3;
		System.out.print(solve(hand,groupSize));
	}
	
	public static boolean solve(int[] hand, int groupSize) {
		if((hand.length % groupSize!=0)) return false;
		TreeMap<Integer,Integer>map=new TreeMap<>();
		List<Integer> list=new ArrayList<>();
		for(int n:hand) {
			map.put(n,map.getOrDefault(n,0)+1);
		}
		while(!map.isEmpty()) {
			int key=map.firstKey();
			list.add(key);
			map.put(key,map.get(key)-1);
			if(map.get(key)==0) {
				map.remove(key);
			}
			key++;
			for(int i=1;i<groupSize;i++) {
				if(map.containsKey(key)) {
					list.add(key);
					map.put(key,map.get(key)-1);
					if(map.get(key)==0) {
						map.remove(key);
					}
					key++;
				}
				else {
					return false;
				}
				
			}
		}
		return true;
	}

}
