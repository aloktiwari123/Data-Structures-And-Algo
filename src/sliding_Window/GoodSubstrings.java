package sliding_Window;
/*
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.
 */
import java.util.*;
public class GoodSubstrings {
	
	public static void main(String args[]) {
		System.out.print(goodSubstring("xyzzaz"));
	}
	
	public static int goodSubstring(String s) {
		int i=0,j=0;
		HashMap<Character,Integer> ch=new HashMap<>();
		int count=0;
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			ch.put(arr[j],ch.getOrDefault(arr[j],0)+1);
			if((j-i+1)<3) {
				j++;
			}
			else if((j-i+1)==3) {
				if(ch.size()==3) {
					count++;
				}
			    ch.put(arr[i],ch.get(arr[i])-1);
			    if(ch.get(arr[i])==0) {
			    	ch.remove(arr[i]);
			    }
				i++;
				j++;
			}
		}
		return count;
	}

}
