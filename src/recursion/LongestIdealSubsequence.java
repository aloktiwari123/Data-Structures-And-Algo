package recursion;

public class LongestIdealSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		int k = 3;
		System.out.print(solve(s,"",0,k));
	}
	
	public static int solve(String in,String op,int max,int k) {
		if(in.length()==0) {
			//System.out.println(op);
			return max;
		}
		
		char ch1=in.charAt(in.length()-1);
		in=in.substring(0,in.length()-1);
		if(op.equals("")) {
			return Math.max(solve(in,ch1+op,max+1,k),solve(in,op,max,k));
		}
		else {
			char ch2=op.charAt(op.length()-1);
			if(Math.abs(ch1-ch2)<=k) {
				return Math.max(solve(in,ch1+op,max+1,k),solve(in,op,max,k));
			}
			else {
				return solve(in,op,max,k);
			}
		}
		
	}

}
