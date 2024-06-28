package heap;

import java.util.PriorityQueue;
public class MaxScoreRemovingStones {
	public static void main(String args[]) {
		int a=4;
		int b=4;
		int c=6;
		System.out.print(solve(a,b,c));
	}
	
	public static int solve(int a,int b,int c) {
		PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->(y-x));
		pq.add(a);
		pq.add(b);
		pq.add(c);
		int moves=0;
		while(pq.peek()!=0) {
			int one=pq.poll();
			int two;
			if(pq.peek()==0) {
				return moves;
			}
			else {
				two=pq.poll();
				moves+=1;
			}
			pq.add(one-1);
			pq.add(two-1);
		}
		return moves;
	}
}
