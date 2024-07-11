package stack;
import java.util.*;
public class ReverseSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="a(bcdefghijkl(mno)p)q";
		System.out.print(solve(s));
	}
	
	public static String solve(String s) {
		char[] arr=s.toCharArray();
		Stack<Character> st=new Stack<>();
		
		for(char ch:arr) {
			if(ch==')') {
				List<Character> str=new ArrayList<>();
				while(st.peek()!='(') {
					str.add(st.pop());
				}				
				st.pop();
				for(Character chr:str) {
					st.add(chr);
			     }
			}
			else {
				st.add(ch);
			}
		}
		StringBuilder stb=new StringBuilder();
		while(!st.isEmpty()) {
			stb.append(st.pop());
		}
		stb.reverse();
		return stb.toString();
	}

}
