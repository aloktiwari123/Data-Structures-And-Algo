package heap;
import java.util.*;
public class RelativeRanks {
	public static void main(String args[]) {
		int[] arr= {10,3,8,9,4};
		System.out.print(Arrays.toString(solve(arr)));
	}
	
	public static String[] solve(int[] arr) {
		PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
		for(int i=0;i<arr.length;i++) {
			pq.add(new int[] {arr[i],i});
		}
		String[] res=new String[arr.length];
		int c=1;
		//"Gold Medal","Silver Medal","Bronze Medal"
		while(pq.size()!=0) {
			int[] temp=pq.poll();
			if(c==1) {
				res[temp[1]]="Gold Medal";
			}
			else if(c==2) {
				res[temp[1]]="Silver Medal";
			}
			else if(c==3) {
				res[temp[1]]="Bronze Medal";
			}
			else {
				res[temp[1]]=""+c;
			}
			c+=1;
		}
		return res;
	}

}
