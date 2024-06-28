package sliding_Var_Window;
// Longest substring with k unique characters
import java.util.*;
public class LongestSubstringWithKUniqueChar {
	
	public static void main(String args[]) {
		System.out.print(longestSubString("aabacbebebe",3));
	}
	
	public static int longestSubString(String s,int k) {
		int max=0;
		int i=0,j=0;
		HashMap<Character,Integer> map= new HashMap<>();
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			if(map.size()<k) {
				j++;
			}
			else if(map.size()==k) {
				max=Math.max(max,(j-i+1));
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
				j++;
			}
		}
		
		return max;
	}

}
