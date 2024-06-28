package sliding_Var_Window;
import java.util.*;
public class countCompleteSubarrays {
	
	public static void main(String args[]) {
		int[] arr= {5,5,5,5};
		HashSet<Integer> set=new HashSet<>();
		for(int k:arr) {
			set.add(k);
		}
		int len=set.size();
		System.out.print(solve(arr,len)-solve(arr,len-1));
	}
	
	public static int solve(int[] arr,int len) {
		int i=0;
		int j=0;
		int count=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			if(map.size()<=len) {
				count+=(j-i+1);
				j++;
			}
			else if(map.size()>len) {
				while(map.size()>len) {
					map.put(arr[i],map.get(arr[i])-1);
					if(map.get(arr[i])==0) {
						map.remove(arr[i]);
					}
					i++;
				}
				count+=(j-i+1);
				j++;
			}	
		}
		return count;
	}

}
