package stack;
import java.util.*;
public class premptiveScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>logs=new ArrayList<String>() {{
			add("0:S:0");
			add("1:S:3");
			add("1:E:6");
			add("2:S:8");
			add("2:E:10");
			add("0:E:12");
			
		}};
		int n=3;
		solve(logs,n);
		
	}
	
	public static int[] solve(List<String> logs,int n) {
		Stack<String[]>st=new Stack<>();
		int[] res=new int[n];
		int callTime=0;
		for(String log:logs) {
			String[] str=log.split(":");
			int time=Integer.valueOf(str[2]);
			int job=Integer.valueOf(str[0]);
			
			if(!st.isEmpty()) {
				String[] temp=st.peek();
				if(temp[0].equals(job)) {
					res[job]=time-Integer.valueOf(temp[2])+1;
					System.out.println(res[job]);
					st.pop();
				}
				else {
					temp[2]=String.valueOf(time-callTime+1);
					st.pop();
					st.push(temp);
					
				}
			}
			else {
				st.push(str);
			}
			
			callTime=time;
		}
		return res;
	}

}
