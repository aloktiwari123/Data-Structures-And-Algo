package stack;
import java.util.*;
public class nextLargestElemLeft {

	public static void main(String args[]) {
		int[] arr= {1,3,2,4};
		System.out.print(Arrays.toString(solve(arr)));
	}
	
	public static int[] solve(int[] arr) {
		int[] ans=new int[arr.length];
		Stack<Integer>st=new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			while(!st.isEmpty() && st.peek()<arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i]=-1;
			}
			else {
				ans[i]=st.peek();
			}
			st.add(arr[i]);
		}
		return ans;
	}
}
