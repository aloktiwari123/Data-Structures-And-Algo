package stack;

import java.util.*;

public class RemovingStarsFromString {
	
	public static void main(String args[]) {
		String str="leet**cod*e";
		System.out.print(solve(str));
	}
	
	public static String solve(String s) {
		char[] arr=s.toCharArray();
		Deque<Character> st = new ArrayDeque<>();  
		for(char ch:arr) {
			if(ch=='*') {
				st.pop();
			}else {
				st.push(ch);
			}
		}
		StringBuilder str=new StringBuilder();
		while(!st.isEmpty()) {
			str.append(st.pollLast());
		}
		return str.toString();
	}
}
