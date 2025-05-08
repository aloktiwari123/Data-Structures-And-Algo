package sliding_Var_Window;
import java.util.HashMap;

public class DistinctSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,9,9};
		int k = 3;
		System.out.print(solve(nums,k));
	}
	
	public static long solve(int[] arr,int k) {
		int i=0;
		int j=0;
		long sum=0;
		long max=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		while(j<arr.length) {
			sum+=arr[j];
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				max=(j-i+1)==map.size()?Math.max(max,sum):max;
				map.put(arr[i],map.get(arr[i])-1);
				if(map.get(arr[i])==0) map.remove(arr[i]);
				sum-=arr[i];
				i++;
				j++;
			}
		}
		return max;
	}

}
