package stack;
import java.util.*;

public class MinLenAfterRemovingSubString {
	public static void main(String args[]) {
		String str="ACBBD";
		System.out.print(solve(str));
	}
	
	public static int solve(String s) {
		char[] arr=s.toCharArray();
		Stack<Character>st=new Stack<>();
		for(char ch:arr) {
			if(ch=='B'||ch=='D') {
				char temp=st.peek();
				if(temp== 'A'||temp== 'C') {
					st.pop();
				}
				else {
					st.push(ch);
				}
			}else {
				st.push(ch);
			}
		}
		return st.size();
	}
}
