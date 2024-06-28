package prefixSum;
import java.util.*;
public class LongestSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;int k = 5; int array[] = {2,3,5};
		//int N = 3;int k = 1;int array[] = {-1, 1, 1};
		System.out.print(solve(array,k));
	}
	
	public static int solve(int[] nums,int k) {
		HashMap<Integer,Integer>map=new HashMap<>();
		map.put(0, -1);
		int sum=0;
		int max=0;
		for(int i=0;i<nums.length;i++) {
			sum=sum+nums[i];
			int target=sum-k;
			if(map.containsKey(target)) {
				max=Math.max(max,i-map.get(target));
			}
			else {
				map.put(sum,i);
			}
		}
		return max;
	}

}
