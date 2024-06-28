package HashFunction;
import java.util.*;
public class ContinuosSubArray {

	public static void main(String args[]) {
		int[]nums = {1,0};
		int k = 2;
		System.out.print(solve(nums,k));
	}
	
	public static boolean solve(int[] nums,int k) {
		HashMap<Integer,Integer>map=new HashMap<>();
		map.put(0, -1);
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			int rem=sum%k;
			if((map.containsKey(rem)) && (i-map.get(rem))>1 ) {
				return true;
			}else {
				map.put(rem,i);
			}
		}
		return false;
	}
}
