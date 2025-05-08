package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyCalendar {
	
	static List<int[]>list=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] interval= {{47,50},{33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}}; 
		for(int[] intr:interval) {
			System.out.println(solve(intr[0],intr[1]));
		}
		
	}
	
	public static boolean solve(int start,int end) {
		list.sort(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if(o1[0]<o2[0]) return 1;
			else if(o1[0]>o2[0]) return -1;
			else return 0;
		}
		
		});
		
		if(list.isEmpty()) {
			list.add(new int[] {start,end});
			return true;
		}
		else {
			for(int[] lst:list) {
				if(start>=lst[0] && start>=lst[1]) {
					list.add(new int[] {start,end});
					return true;
				}else if(start<=lst[0] && end<=lst[0]) {
					list.add(new int[] {start,end});
					return true;
				}
			}
		}
		return false;
		
	}

}
