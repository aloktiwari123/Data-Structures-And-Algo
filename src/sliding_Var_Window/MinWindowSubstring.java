package sliding_Var_Window;
import java.util.*;
public class MinWindowSubstring {
	
	public static void main(String args[]) {
		System.out.println(minWindowSubstring("ADOBECODEBANC","ABC"));
	}
	
	public static String minWindowSubstring(String s,String t) {
		int i=0,j=0;
		int min=Integer.MAX_VALUE;
		HashMap<Character,Integer>map=new HashMap<>();
		for(char ch:t.toCharArray()) {
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		int count=map.size();
		String s1=s;
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			if(map.containsKey(arr[j])) {
				map.put(arr[j],map.get(arr[j])-1);
				if(map.get(arr[j])==0) {
					count=count-1;
				}
				if(count==0) {
					//min=Math.min(min,(j-i+1));
					if((j-i+1)<s1.length()) {
						s1=s.substring(i,j+1);
					}
					while(count==0) {
						if(map.containsKey(arr[i])) {
							map.put(arr[i],map.get(arr[i])+1);
							if(map.get(arr[i])>0) {
								count++;
							}
						}
						if((j-i+1)<s1.length()) {
							s1=s.substring(i,j+1);
						}
						i++;
					}
					j++;
				}
				else {
					j++;
				}
			}
			else {
				j++;
			}	
			
		}
		
		return s1;
	}

}
