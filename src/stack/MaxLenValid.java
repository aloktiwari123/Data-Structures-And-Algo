package stack;

import java.util.Stack;

public class MaxLenValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="((()())()";
		System.out.print(solve(s));
	}
	
	public static int solve(String s) {
		char[] chars=s.toCharArray();
		Stack<Integer>st=new Stack<>();
		st.add(-1);
		int max=0;
		
		for(int i=0;i<chars.length;i++) {
			if(chars[i]=='(') {
				st.push(i);
			}
			else {
				st.pop();
				if(st.isEmpty()) {
					st.add(i-1);
				}
				max=Math.max(max, i-st.peek());
			}
		}
		return max;
	}
}
