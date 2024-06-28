package stack;
import java.util.*;
public class DailyTemperature {
	
	public static void main(String args[]) {
		int[] temp= {30,40,50,60};
		System.out.print(Arrays.toString(solve(temp)));
	}
	
	public static int[] solve(int[] temp) {
		int[] ans=new int[temp.length];
		Stack<int[]>st=new Stack<>();
		for(int i=temp.length-1;i>=0;i--) {
			while(!st.isEmpty() && st.peek()[0]<temp[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i]=0;
			}
			else {
				ans[i]=st.peek()[1]-i;
			}
			st.add(new int[] {temp[i],i});
		}
		return ans;
	}

}
