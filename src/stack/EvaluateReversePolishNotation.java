package stack;
import java.util.*;
public class EvaluateReversePolishNotation {
	
	public static void main(String args[]) {
		String[] arr= {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.print(solve(arr));
	}
	
	public static int solve(String[] arr) {
		Stack<Integer>st=new Stack<>();
		int o1,o2;
		for(String s:arr) {
			if(s.equals("+")) {
				o1=st.pop();
				o2=st.pop();
				st.add(o2+o1);
			}
			else if(s.equals("*")) {
				o1=st.pop();
				o2=st.pop();
				st.add(o2*o1);	
			}
			else if(s.equals("-")) {
				o1=st.pop();
				o2=st.pop();
				st.add(o2*o1);	
			}
			else if(s.equals("/")) {
				o1=st.pop();
				o2=st.pop();
				st.add(o2/o1);
			}
			else {
				st.add(Integer.valueOf(s));
			}
		}
		return st.pop();	
	}

}
