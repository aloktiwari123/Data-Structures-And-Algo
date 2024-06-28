package BackTracking;
import java.util.*;
public class Subsets {
	public static void main(String args[]) {
		List<List<Integer>>list=new ArrayList<>();
		List<Integer>op=new ArrayList<>();
		int[] arr= {1,1,3};
		solve(arr,0,op,list);
		System.out.print(list);
	}

	public static void solve(int[] arr,int idx,List<Integer>op,List<List<Integer>>list) {
		if(idx==arr.length) {
			list.add(new ArrayList<>(op));
			return;
		}
		solve(arr,idx+1,op,list);
		//op.add(arr[idx]);
		List<Integer>op1=new ArrayList<>(op);
		op1.add(arr[idx]);
		solve(arr,idx+1,op1,list);
		//op.remove(op.size()-1);
	}
	
}
