package DynamicPrograming;
import java.util.*;
public class StoneGame {
	public static void main(String args[]) {
		int[] arr= {1,5,2};
		HashMap<String,Boolean>map=new HashMap<>();
		boolean ans=solve(0,arr.length-1,0,0,1,arr,map);
		System.out.print(ans);
	}
	
	public static boolean solve(int start,int end,int p1,int p2,int turn,int[]arr,HashMap<String,Boolean>map) {
		if(start>end) {
			return p1>p2;
		}
		String key=start+"|,|"+end+"|,|"+turn;
		if(map.containsKey(key)) {
			return map.get(key);
		}
        boolean p1_first = false;
        boolean p1_last = false;
        boolean p2_first = false;
        boolean p2_last = false;
		if(turn == 1) {
			p1_first=solve(start+1,end,p1+arr[start],p2,0,arr,map);
			map.put(key,p1_first);
			p1_last=solve(start,end-1,p1+arr[end],p2,0,arr,map);
			map.put(key,p1_last);
		}
		if(turn == 0) {
			p2_first=solve(start+1,end,p1,p2+arr[start],1,arr,map);
			map.put(key,p2_first);
			p2_last=solve(start,end-1,p1,p2+arr[end],1,arr,map);
			map.put(key,p2_last);
		}
		
		return p1_first||p2_first||p1_last||p2_last;
	}

}
