package heap;
import java.util.*;
public class KWeakestRows {
	
	public static void main(String args[]) {
		int[][] arr= {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
		System.out.print(Arrays.toString(solve(arr,3)));
	}
	
	public static int[] solve(int[][] arr,int k) {
		PriorityQueue<Pair>pq=new PriorityQueue<>();
		int[] res=new int[k];
		int n=arr.length;
		int m=arr[0].length;
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1)
				{
					count+=1;
				}	
			}
			pq.add(new Pair(i,count));
		}
		for(int i=0;i<k;i++) 
		{
			res[i]=pq.poll().idx;
		}
		return res;
	}


}
class Pair implements Comparable<Pair> {
	int idx;
	int count;
	
	Pair(int idx,int count){
		this.idx=idx;
		this.count=count;
		
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if(this.count!=o.count) {
			return Integer.compare(this.count,o.count);
		}
		else {
			return Integer.compare(this.idx,o.idx);
		}
	}

	@Override
	public String toString() {
		return "Pair [idx=" + idx + ", count=" + count + "]";
	}
	
}




