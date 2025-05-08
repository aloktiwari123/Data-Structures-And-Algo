package stack;
import java.util.*;
public class MaximumGain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaaxybbaabb";
		int x = 5;
		int y = 4;
		System.out.print(solve(s,x,y));
	}

	private static int solve(String s, int x, int y) {
		// TODO Auto-generated method stub
		int score=0;
		String priority=x>y?"ab":"ba";
		String lowpriority=priority.equals("ab")?"ba":"ab";
		String res=removeSubstring(s,priority);
		score+=((s.length()-res.length())/2)*(x>y?x:y);
		
		String resf=removeSubstring(res,lowpriority);
		score+=((res.length()-resf.length())/2)*(x<y?x:y);
		
		return score;
	}
	
	public static String removeSubstring(String s,String target) {
		char[] arr=s.toCharArray();
		Stack<Character> st=new Stack<>();
		
		for(char ch:arr) {
			if(ch == target.charAt(1) && !st.isEmpty() && st.peek() == target.charAt(0)) {
				st.pop();
			}
			else {
				st.push(ch);
			}
		}
		
		StringBuilder str=new StringBuilder();
		while(!st.isEmpty()) {
			str.append(st.pop());
		}
		
		return str.reverse().toString();
		
	}
}
