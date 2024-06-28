package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
	public static void main(String args[]) {
		List<List<Integer>>list=new ArrayList<>();
		List<Integer>op=new ArrayList<>();
		int[]nums= {1,2,2};
		solve(nums,0,op,list);
		HashSet<List<Integer>>set=new HashSet<>();
		List<List<Integer>>Rlist=new ArrayList<>();
		for(List<Integer>i:list) {
			if(set.contains(i)) {
				Rlist.add(i);
			}
			set.add(i);
		}
		list.removeAll(Rlist);
		list.addAll(Rlist);
		System.out.print(list);
	}

	public static void solve(int[] nums,int idx,List<Integer>op,List<List<Integer>>list) {
		if(idx==nums.length) {
			list.add(new ArrayList<>(op));
			return;
		}
		
		solve(nums,idx+1,op,list);
		List<Integer>op1=new ArrayList<>(op);
		op1.add(nums[idx]);
		solve(nums,idx+1,op1,list);
	}

}
