package recursion;
/*
 * S1 = "0"
 * Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
 */
public class KthBitInNthBinaryString {
	public static void main(String args[]) {
		String s="011";
		//System.out.print(reverse(s));
		System.out.print(solve(3).charAt(1));
	}
	
	public static String solve(int k) {
		if(k==1) {
			return "0";
		}
		String temp=solve(k-1);
		return temp+"1"+reverse(temp);
	}
	
	public static String reverse(String s) {
		StringBuilder st=new StringBuilder();
		for(char ch:s.toCharArray()) {
			st.append(ch=='1'?'0':'1');
		}
		st.reverse();
		return st.toString();
	}

}
