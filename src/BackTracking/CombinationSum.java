package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	static List<List<Integer>>list=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,5,2,1,2};
		int target = 5;
		Arrays.sort(candidates);
		solve(new ArrayList<Integer>(),target,candidates,0);
		System.out.print(list);
	}
	
	public static void solve(List<Integer>choices,int target,int[] candidates,int idx) {
		if(target<=0 || idx==candidates.length) {
			if(target==0) {
				if(!list.contains(choices))list.add(choices);
			}
			return;
		}
		int previous=-1;
		for(int i=idx;i<candidates.length;i++) {
			if(candidates[i]<=target && previous!=candidates[i]) {
				List<Integer> new_Choices=new ArrayList<>(choices);
				new_Choices.add(candidates[i]);
				solve(new_Choices,target-candidates[i],candidates,i+1);
			}
			previous=candidates[i];
		}
	}

}
