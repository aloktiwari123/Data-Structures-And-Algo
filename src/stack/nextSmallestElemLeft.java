package stack;

import java.util.Arrays;
import java.util.Stack;

public class nextSmallestElemLeft {
	
	public static void main(String args[]) {
		int[] arr= {1,3,2,4};
		System.out.print(Arrays.toString(next_SmallestElem(arr)));
	}
	
	public static int[] next_SmallestElem(int[] arr){
		int[] ans=new int[arr.length];
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			while(!stack.isEmpty() && stack.peek()>arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				ans[i]=-1;
			}
			else {
				ans[i]=stack.peek();
			}
			stack.add(arr[i]);
		}
		return ans;
	}

}
