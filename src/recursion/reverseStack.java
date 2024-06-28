package recursion;

import java.util.Stack;

public class reverseStack {
	
	public static void main(String args[]) {
		Stack<Integer>st=new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.print(st);
		reverse(st);
		System.out.print(st);
		
	}
	
	public static void reverse(Stack<Integer>st) {
		
		if(st.size()==1) {
			return;
		}

		int temp=st.peek();
		st.pop();
		reverse(st);
		insert(st,temp);
		return;
	}
	
	public static void insert(Stack<Integer>st,int temp) {
		
		if(st.isEmpty()) {
			st.push(temp);
			return;
		}
		
		int val=st.peek();
		st.pop();
		insert(st,temp);
		st.push(val);
		
	}

}
