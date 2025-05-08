package BackTracking;
import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
	static List<String> ans = new ArrayList<>();	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "25525511135";
		solve(s,0,new ArrayList<>(),ans);
		System.out.print(ans);
	}
	
	public static boolean valid(String s,int start,int length) {
		return (length ==1 || (s.charAt(start) !='0' && (length < 3 || s.substring(start, start + length).compareTo("255") <= 0)));
	}
	
	
	public static void solve(String s,int startIndex,List<Integer>dots,List<String>ans) {
		int remainingLength=s.length()-startIndex;
		int remainingIntegers=4-dots.size();
		
		if(remainingLength>remainingIntegers*3 || remainingLength<remainingIntegers) {
			return;
		}
		
		 if (dots.size() == 3) {
	            if (valid(s, startIndex, remainingLength)) {
	                StringBuilder sb = new StringBuilder();
	                int last = 0;
	                for (Integer dot : dots) {
	                    sb.append(s.substring(last, last + dot));
	                    last += dot;
	                    sb.append('.');
	                }
	                sb.append(s.substring(startIndex));
	                ans.add(sb.toString());
	            }
	            return;
	        }
		 
		for(int i=1;i<=3 && i<=remainingLength;i++) {
			dots.add(i);
			if(valid(s,startIndex,i)) {
				solve(s,startIndex+i,dots,ans);
			}
			dots.remove(dots.size()-1);
		}
	}	

}
