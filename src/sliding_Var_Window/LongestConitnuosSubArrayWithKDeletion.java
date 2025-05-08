package sliding_Var_Window;

import java.util.HashMap;

public class LongestConitnuosSubArrayWithKDeletion {

	public static void main(String args[]) {
		int[] arr= {7,5,7,7,1,1,7,7};
		System.out.print(solve(arr));
	}
	
	public static int solve(int[] arr) {
		int i=0;
		int j=0;
		int max=0;
		int max_freq=-1;
		int k=3;
		HashMap<Integer,Integer>map=new HashMap<>();
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			max_freq=Math.max(map.get(arr[j]), max_freq);
			if(((j-i+1)-max_freq)<k) {
				j++;
			}
			else if(((j-i+1)-max_freq)==k){
				max=Math.max(max,(j-i+1));
				j++;
			}
			else if(((j-i+1)-max_freq)>k){
				while(((j-i+1)-max_freq)>k){
					if(arr[i]==1) {
						max_freq-=1;
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}


}
