package heap;
import java.util.*;
public class minStoneSum {

	public static void main(String args[]) {
		int[] arr= {5,4,9};
		System.out.println(solve(arr,2));
	}
	
	public static int solve(int[] arr,int k) {
		PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->(b-a));
		for(int i:arr) {
			pq.add(i);
		}
		while(k!=0) {
			int temp=pq.poll();
			int newVal=(int) Math.floor(temp/2);
			temp=temp-newVal;
			pq.add(temp);
			k-=1;
		}
		int sum=0;
		while(!pq.isEmpty()) {
			sum+=pq.poll();
		}
		return sum;
	}
}
