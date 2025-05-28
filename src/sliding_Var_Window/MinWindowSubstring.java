package sliding_Var_Window;
import java.util.*;
public class MinWindowSubstring {
	
	public static void main(String args[]) {
		System.out.println(minWindowSubstring("ADOBECODEBANC","ABC"));
	}
	
	public static String minWindowSubstring(String s,String t) {
		int i=0,j=0;
		int minLen=Integer.MAX_VALUE;
		int startIdx=-1;
		int[] freq=new int[256];
		char[] temp=t.toCharArray();
		for(char ch:temp) {
			freq[ch]++;
		}
		int count=0;
		int m=t.length();
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			if(freq[arr[j]]>0) count++;
			freq[arr[j]]--;
			while(count==m) {
				if(minLen>(j-i+1)) {
					minLen=(j-i+1);
					startIdx=i;
				}
				freq[arr[i]]++;
				if(freq[arr[i]]>0)count--;
				i++;
			}
			j++;
		}
		
		return startIdx==-1?"":s.substring(startIdx,startIdx+minLen);
	}
	
	

}
