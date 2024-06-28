package sliding_Var_Window;

import java.util.HashMap;

// Longest substring without repeating characters
public class LongestSubstringWithoutRepatingChar {
	public static void main(String args[]) {
		System.out.print(longestSubString("pwwkew"));
	}
	
	public static int longestSubString(String s) {
		int max=0;
		int i=0,j=0;
		HashMap<Character,Integer> map= new HashMap<>();
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			if(map.size()==(j-i+1)) {
				max=Math.max(max,(j-i+1));
				j++;
			}
			else if(map.size()<(j-i+1)){
				while(map.size()<(j-i+1)) {
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
