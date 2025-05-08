package HashFunction;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MaxSumPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401};
		System.out.println(solve(nums));
	}
	
	public static int solve(int[] nums) {
		HashMap<Integer,PriorityQueue<Integer>>map=new HashMap<>();
		int max=-1;
		for(int i=0;i<nums.length;i++) {
			int sum=getSumOfDigits(nums[i]);
			if(map.containsKey(sum)) {
				PriorityQueue<Integer> temp=map.get(sum);
				temp.add(nums[i]);
				int num1=temp.poll();
				int num2=temp.poll();
				max=Math.max(max,num1+num2);
				temp.add(num1);
				temp.add(num2);
			}else {
				PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
				pq.add(nums[i]);
				map.put(sum,pq);
			}
		}
		return max;
	}

	private static int getSumOfDigits(int num) {
		// TODO Auto-generated method stub
		int sum=0;
		
		while(num>0) {
			sum+=num%10;
			num=num/10;
			
		}
		return sum;
	}


}
