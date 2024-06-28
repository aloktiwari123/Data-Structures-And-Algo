package recursion;
import java.util.*;
public class SortByPower {
	public static void main(String args[]) {
		System.out.print(sortPower(12,15,2));

	}
	
	public static int sortPower(int lo,int hi,int k) {
		PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]==a[1]?b[0]-a[0]:b[1]-a[1]);
		for(int i=lo;i<=hi;i++) {
			pq.add(new int[]{i,getPower(i)});
			while(pq.size()>k) {
				pq.poll();
			}
		}
		return pq.peek()[0];
	}
	
	public static int getPower(int n) {
		if(n==1) {
			return 0;
		}
		if(n%2==0) {
			return 1+getPower(n/2);
		}else {
			return 1+getPower((3*n)+1);
		}
	}
}
