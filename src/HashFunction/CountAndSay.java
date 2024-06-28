package HashFunction;
import java.util.*;
public class CountAndSay {
	
	public static void main(String args[]) {
		System.out.print(solve(5));
	}
	
	public static String solve(int n) {
		if(n==1) {
			return "1";
		}
		
		String s=solve(n-1);
		int c=0;
		StringBuilder str=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			c++;
			if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1)) {
				str.append(c).append(s.charAt(i));
				c=0;
			}
		}
		return str.toString();
	}
	
//	public static LinkedHashMap<Integer,Integer>count(String s){
//		LinkedHashMap<Integer,Integer>map=new LinkedHashMap<>();
//		for(char ch:s.toCharArray()) {
//			int num=ch-'0';
//			map.put(num,map.getOrDefault(num,0)+1);
//		}
//		return map;
//	}
//	
//	public static String say(LinkedHashMap<Integer,Integer>map) {
//		StringBuilder s=new StringBuilder();
//		for(Map.Entry<Integer,Integer>entry:map.entrySet()) {
//			s.append(entry.getValue());
//			s.append(entry.getKey());
//		}
//		return s.toString();
//	}

}
