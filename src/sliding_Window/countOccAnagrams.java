package sliding_Window;

import java.util.*;

public class countOccAnagrams {
	
	public static void main(String args[]) {
		String s="forxxorfxdofr";
		String ptr="for";
//		String s="aabaabaa";
//		String ptr="aaba";
		System.out.println(Count_OccAnagrams(s,ptr));
	}
	
	public static int Count_OccAnagrams(String s,String ptr) {
		Map<Character,Integer> ptrMap= new HashMap<>();
		for(char ch:ptr.toCharArray()) {
			ptrMap.put(ch,ptrMap.getOrDefault(ch,0)+1);
		}
		int i=0;
		int j=0;
		int k=ptr.length();
		int count=0;
		Map<Character,Integer> sMap= new HashMap<>();
		char[] sArray=s.toCharArray();
		while(j<s.length()) {
			sMap.put(sArray[j],sMap.getOrDefault(sArray[j],0)+1);
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				if(ptrMap.equals(sMap)) {
					count++;
				}
				sMap.put(sArray[i],sMap.get(sArray[i])-1);
				if(sMap.get(sArray[i])==0) {
					sMap.remove(sArray[i]);
				}
				i++;
				j++;
			}		
		}
		return count;
	}

}
