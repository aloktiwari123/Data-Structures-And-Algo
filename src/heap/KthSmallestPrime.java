package heap;
import java.util.*;
public class KthSmallestPrime {
	public static void main(String args[]) {
		int[] arr= {1,2,3,5};
		System.out.print(Arrays.toString(solve(arr,3)));
	}
	
	public static int[] solve(int[] arr,int k) {
		PriorityQueue<Pairs>pq=new PriorityQueue<>((p,q)->(Double.compare(q.fraction,p.fraction)));
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				pq.add(new Pairs(arr[i],arr[j]));
				while(pq.size()>k) {
					pq.poll();
				}
			}
		}
		return pq.poll().arr;
	}

}

class Pairs{
	Double fraction;
	int[] arr=new int[2];
	
	Pairs(int a,int b){
		fraction=Double.valueOf(a)/Double.valueOf(b);
		arr[0]=a;
		arr[1]=b;
	}
}
