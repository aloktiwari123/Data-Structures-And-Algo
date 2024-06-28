package sliding_Var_Window;
import java.util.*;
public class ContiguousArray {

	public static void main(String args[]) {
		 int[]nums = {0,1};
		 System.out.print(solve(nums));
	}
	
	public static int solve(int[] arr) {
		HashMap<Integer,Integer>map=new HashMap<>();
		map.put(0,-1);
		int j=0;
		int count=0;
		int max=0;
		while(j<arr.length) {
			count+=arr[j]==1?1:-1;
			if(map.containsKey(count)) {
				max=Math.max(max,j-map.get(count));
			}
			else {
				map.put(count,j);
			}
			j++;
		}
		return max;
	}
}
