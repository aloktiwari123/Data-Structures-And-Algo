package heap;
import java.util.*;
public class KClosestElements {
	
	public static void main(String args[]) {
		int[] nums= {5,6,7,8,9};
		System.out.println(Arrays.toString(solve(nums,3,7)));
		
	}
	
	public static  int[] solve(int[] arr, int k, int x) {
		PriorityQueue<int[]> pq=new PriorityQueue<>(new compareTo());
		for(int i=0;i<arr.length;i++) {
			pq.add(new int[]{Math.abs(arr[i]-x),arr[i]});
 			while(pq.size()>k) {
				pq.poll();
			}
		}
		int[] res=new int[k];
		while(pq.size()!=0) {
			res[--k]=pq.poll()[1];
		}
		return res;
	}

}

class compareTo implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		if(o1[0]>o2[0]) {
			return -1;
		}
		else if(o1[0]<o2[0]) {
			return 1;
		}
		return 0;
	}
	
}

