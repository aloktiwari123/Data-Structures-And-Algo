package sliding_Var_Window;
import java.util.*;
public class SubarrayWithAtMostKdiffInt {
	
    public static int subarraysWithAtmostKDistinct(int[] nums, int k) {
        int count=0;
		int i=0,j=0;
		HashMap<Integer,Integer> map= new HashMap<>();
		int[] arr=nums;
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			while(map.size()>k) {
					map.put(arr[i],map.get(arr[i])-1);
					if(map.get(arr[i])==0) {
						map.remove(arr[i]);
					}
					i++;
				}
				count+=(j-i+1);
				j++;
			}
		return count;
    }
    
    public static int subarraysWithAtmostKDistinct_AV(int[] nums, int k) {
        int count=0;
		int i=0,j=0;
		HashMap<Integer,Integer> map= new HashMap<>();
		int[] arr=nums;
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			if(map.size()<=k) {
				count+=(j-i+1);
				j++;
			}
			else if(map.size()>k) {
				while(map.size()>k) {
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
    
    public static void main(String args[]) {
    	int[] arr= {1,2,1,2,3};
    	//System.out.print(subarraysWithKDistinct(arr,2)-(subarraysWithKDistinct(arr,1)));
    	//Count of Sub array with K distinct integers 
    	System.out.print(subarraysWithAtmostKDistinct_AV(arr,2)-(subarraysWithAtmostKDistinct_AV(arr,1)));
    }

}
