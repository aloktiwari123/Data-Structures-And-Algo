package HashFunction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountBadPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,1,3,3};
		System.out.println(solve(nums));
	}
	
	public static long solve(int[] nums) {
		HashMap<Integer,Integer>map=new HashMap<Integer, Integer>();
		long good=0;
//		for(int i=0;i<nums.length;i++) {
//			int num=nums[i];
//			int diff=num-i;
//			good+=map.getOrDefault(diff,0);
//			map.put(diff,map.getOrDefault(diff,0)+1);
//		}
		// stream
		good=IntStream.range(0,nums.length).mapToLong(i->{
			int diff=nums[i]-i;
			int count=map.getOrDefault(diff,0);
			map.put(diff,map.getOrDefault(diff,0)+1);
			return count;
		}).sum();
		long n=nums.length;
		long totalPairs=(n*(n-1))/2;
		return totalPairs-good;
	}

}
