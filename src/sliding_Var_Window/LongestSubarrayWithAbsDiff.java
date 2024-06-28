package sliding_Var_Window;
import java.util.*;
public class LongestSubarrayWithAbsDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,1,2,4,7,2};
		int limit = 5;
		System.out.print(solve1(nums,limit));
	}
	
	// two heaps
	public static int solve(int[] nums,int limit) {
		PriorityQueue<Integer>maxPq=new PriorityQueue<>((a,b)->(b-a));
		PriorityQueue<Integer>minPq=new PriorityQueue<>((a,b)->(a-b));
		int i=0;
		int j=0;
		int min=0;
		int max=0;
		int ans=0;
		while(j<nums.length) {
			maxPq.add(nums[j]);
			minPq.add(nums[j]);
			min=minPq.peek();
			max=maxPq.peek();
			if(Math.abs(min-max)<=limit) {
				ans=Math.max(ans,(j-i+1));
				j++;
			}else {
				while(Math.abs(min-max)>limit) {
					maxPq.remove(nums[i]);
					minPq.remove(nums[i]);
					min=minPq.peek();
					max=maxPq.peek();
					i++;
				}
				ans=Math.max(ans,(j-i+1));
				j++;
			}
		}
		return ans;
		
	}
	
	// tree map which maintains min and max at the same time
	public static int solve1(int[] nums,int limit) {
		TreeMap<Integer,Integer>map=new TreeMap<>();
		int i=0;
		int j=0;
		int min=0;
		int max=0;
		int ans=0;
		
		while(j<nums.length) {
			map.put(nums[j],map.getOrDefault(nums[j],0)+1);
			min=map.firstKey();
			max=map.lastKey();
			if(Math.abs(min-max)<=limit) {
				ans=Math.max(ans,(j-i+1));
				j++;
			}else {
				while(Math.abs(min-max)>limit) {
					map.put(nums[i],map.get(nums[i])-1);
					if(map.get(nums[i])==0) {
						map.remove(nums[i]);
					}
					min=map.firstKey();
					max=map.lastKey();
					i++;
				}
				ans=Math.max(ans,(j-i+1));
				j++;
			}
		}
		return ans;
			
		}
}
