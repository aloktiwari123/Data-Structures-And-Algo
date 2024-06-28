package recursion;
/*
 * Delete middle element of the stack
 */
import java.util.*;
public class deleteMiddleElementStack {
	
	public static void main(String args[]) {
		Stack<Integer>st=new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		int k=(st.size()/2)+1;
		System.out.print(st);
		solve(st,k);
		System.out.print(st);
		
	}
	
	public static void solve(Stack<Integer>st,int k) {
		
		if(k==1) {
			st.pop();
			return;
		}
		
		int temp=st.peek();
		st.pop();
		solve(st,k-1);
		st.push(temp);
		return;
	}

}
