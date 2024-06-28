package sliding_Var_Window;
import java.util.*;
public class MaximumEraserValue {
	
	public static void main(String args[]) {
		int[] arr= {5,2,1,2,5,2,1,2,5};
		System.out.print(solve(arr));	
	}
	
	public static int solve(int[] arr) {
		int i=0;
		int j=0;
		int sum=0;
		int max=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			sum+=arr[j];
			if((j-i+1)==map.size()) {
				max=Math.max(sum, max);
				j++;
			}
			else if((j-i+1)>map.size()) {
				while((j-i+1)>map.size()) {
					map.put(arr[i],map.get(arr[i])-1);
					if(map.get(arr[i])==0) {
						map.remove(arr[i]);
					}
					sum-=arr[i];
					i++;
				}
				j++;
			}
		}
		return max;
	}

}
