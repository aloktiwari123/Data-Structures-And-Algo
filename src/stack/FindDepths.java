package stack;
import java.util.*;

public class FindDepths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "()(())()";
		solve(seq);
	}
	
	public static int[] solve(String s) {
		
		int[] arr=new int[s.length()];
		Stack<Character>st=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!st.isEmpty()) {
				if(ch==')' && st.peek()=='(') {
					st.pop();
					arr[i]=st.size();
				}
				else {
					arr[i]=st.size();
					st.add(ch);
				}
			}
			else {
				arr[i]=st.size();
				st.add(ch);
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}

}
