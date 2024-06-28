package stack;
import java.util.*;
public class RemoveKDigits {

	public static void main(String args[]) {
		System.out.print(solve("10200",1));
	}
	
	public static String solve(String s,int k) {
		char[] arr=s.toCharArray();
		Stack<Integer>st=new Stack<>();
		
		for(char ch:arr) {
			int val=ch-'0';
			while(!st.isEmpty()&& st.peek()>val && k>0 ) {
				st.pop();
				k-=1;
			}
			 if(!st.isEmpty() || val!=0)
             {
					st.add(val);
             }
		}
		StringBuilder str=new StringBuilder();
		while(!st.isEmpty()) {
			str.append(st.pop());
		}
		return str.reverse().toString();
	}
}
