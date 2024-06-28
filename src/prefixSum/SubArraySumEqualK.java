package prefixSum;
import java.util.*;
public class SubArraySumEqualK {

	public static void main(String args[]) {
		int[] nums = {1,2,3,-3,1,1,1};
		int k = 3;
		System.out.print(solve(nums,k));
	}
	
    public static int solve(int[] nums,int k) {
		HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
		int sum=0;
		int count=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			int target=sum-k;
			if(map.containsKey(target)) {
				count+=map.get(target);
               
            }
            map.put(sum,map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
