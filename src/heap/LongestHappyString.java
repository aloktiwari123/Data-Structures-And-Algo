package heap;
import java.util.*;
// waste
public class LongestHappyString {
	
	public static void main(String args[]) {
		int a = 1;
		int b = 1;
		int c = 7;
		System.out.print(solve(a,b,c));
	}
	
	public static String solve(int a,int b,int c) {
		PriorityQueue<int[]>pq=new PriorityQueue<>((p,q)->(q[0]-p[0]));
		pq.add(new int[] {a,'a'});
		pq.add(new int[] {b,'b'});
		pq.add(new int[] {c,'c'});
		StringBuilder st=new StringBuilder();
		while(pq.size()>1) {
			int[] largest=pq.poll();
			if(largest[0]>=2) {
				st.append((char)largest[1]);
				st.append((char)largest[1]);
				largest[0]-=2;
			}
			else if(largest[0]<2){
				st.append((char)largest[1]);
				largest[0]-=1;
			}
			int[] largest2=pq.poll();
			if(largest2[0]>=2) {
				st.append((char)largest2[1]);
				st.append((char)largest2[1]);
				largest2[0]-=2;
			}
			else if(largest2[0]<2){
				st.append((char)largest2[1]);
				largest2[0]-=1;
			}
			if(largest[0]>0) {
				pq.add(largest);
			}
			if(largest2[0]>0) {
				pq.add(largest2);
			}
		}
		while(!pq.isEmpty()) {
			int[] largest=pq.poll();
			if(st.charAt(st.length()-1)!=(char)largest[1]) {
				if(largest[0]>=2) {
					st.append((char)largest[1]);
					st.append((char)largest[1]);
				}
				else if(largest[0]<2){
					st.append((char)largest[1]);
				}
			}
			
		}
		
		return st.toString();
	}

}
