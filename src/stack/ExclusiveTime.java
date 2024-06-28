package stack;
import java.util.*;
public class ExclusiveTime {
	public static void main(String args[]) {
		String[] logs= {"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"};
		System.out.print(Arrays.toString(solve(logs,2)));
	}
	public static int[] solve(String arr[],int n) {
		Stack<Log>st=new Stack<>();
		int[] res=new int[n];
		for(String s:arr) {
			Log currLog=new Log(s);
			if(currLog.status==0) {
				Log prevLog=st.pop();
				res[prevLog.process]+=currLog.timeStamp-prevLog.timeStamp+1;
				if(!st.isEmpty()) {
					res[st.peek().process]-=currLog.timeStamp-prevLog.timeStamp+1;
				}
			}
			else {
				st.push(currLog);
			}
		}
		return res;
	}

}

class Log{

	int process;
	int status;
	int timeStamp;
	
	Log(String s){
		String[] arr=s.split(":");
		process=Integer.valueOf(arr[0]);
		status=arr[1].equals("start")?1:0;
		timeStamp=Integer.valueOf(arr[2]);
	}
	
	@Override
	public String toString() {
		return "Log [process=" + process + ", status=" + status + ", timeStamp=" + timeStamp + "]";
	}
}
