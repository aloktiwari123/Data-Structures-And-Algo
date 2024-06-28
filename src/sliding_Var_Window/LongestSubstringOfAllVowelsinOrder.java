package sliding_Var_Window;
import java.util.*;
public class LongestSubstringOfAllVowelsinOrder {

	public static void main(String args[]) {
		String s="aaaaiiiieouuu";
		ArrayList<Integer>li=new ArrayList<>();
		LinkedHashMap<Character,Integer>map=new LinkedHashMap<>();
		Integer c=0;
		li.add(0);
		solve1(li);
		System.out.print(li);
		solve(s,map);
		
		System.out.print(map);
		System.out.print(reverse(123));
	}
	
	public static void solve1(ArrayList<Integer> li) {
		li.set(0,li.get(0)+1);
	}
	
	public static int reverse(int n) {
		int temp=0;
		
		while(n>0) {
			temp=temp*10+n%10;
			n=n/10;
		}
		return temp;
	}
	public static int solve(String s,LinkedHashMap<Character,Integer>map) {
		int i=0;
		int j=0;
		
		String vowel="aeiou";
		String vow="";
		for(char ch:s.toCharArray()) {
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		for(char ch:map.keySet()) {
			vow=vow+ch;
		}
		System.out.print(map);
		System.out.print(map.keySet());
		System.out.print(vow);
		return 0;
	}
}
