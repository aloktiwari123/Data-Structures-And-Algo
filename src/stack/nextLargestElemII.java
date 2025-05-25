package stack;

import java.util.Arrays;
import java.util.Stack;


public class nextLargestElemII {

	public static void main(String args[]) {
		int[] arr= {1,2,1};
		System.out.print(Arrays.toString(next_LargestElem(arr)));
	}
	
	public static int[] next_LargestElem(int[] arr){
		int[] ans=new int[arr.length];
		Stack<Integer> stack=new Stack<>();
		int n=arr.length;
		
		for(int i=2*arr.length-1;i>=0;i--) {
			while(!stack.isEmpty() && stack.peek()<=arr[i%n]) {
				stack.pop();
			}
			
			if(i<n) {
				if(stack.isEmpty()) {
					ans[i]=-1;
				}
				else {
					ans[i]=stack.peek();
				}
			}
			stack.add(arr[i%n]);
		}
		return ans;
	}

}
