package binarySearch;
import java.util.*;
public class kthSmallestElement {

	public static void main(String args[]) {
		int[][] arr= {{1,3,5},{6,7,12},{11,14,14}};
		int k=6;
		PriorityQueue<Data>pq=new PriorityQueue<>(new DataComparator());
		HashSet<String>set=new HashSet<>();
		Data d=new Data(0,0,arr[0][0]);
		set.add(d.view);
		pq.add(d);
		System.out.print(search(arr,k,pq,set));
	}
	
	public static int search(int[][] nums,int k,PriorityQueue<Data>pq,HashSet<String>set) {
		int n=nums.length;
		int m=nums[0].length;
		while(k>1) {
			Data data=pq.poll();
			int i=data.i;
			int j=data.j;
			if(i+1<n) {
				Data d1=new Data(i+1,j,nums[i+1][j]);
				if(!set.contains(d1.view)) {
					pq.add(d1);
					set.add(d1.view);
				}
				
			}
            if(j+1<m){
                Data d2=new Data(i,j+1,nums[i][j+1]);
                if(!set.contains(d2.view)) {
					pq.add(d2);
					set.add(d2.view);
				}
            }
			k-=1;
		}
		return pq.poll().val;
	}
}

class Data{
	int i=0;
	int j=0;
	int val=0;
	String view="";
	Data(int i,int j,int val){
		this.i=i;
		this.j=j;
		this.val=val;
        this.view=val+"-"+i+"-"+j;
	}
	
}

class DataComparator implements Comparator<Data>{

	@Override
	public int compare(binarySearch.Data o1, binarySearch.Data o2) {
		// TODO Auto-generated method stub
		if(o1.val<o2.val) {
			return -1;
		}
		else if(o1.val>o2.val) {
			return 1;
		}
		return 0;
	}

	
}
