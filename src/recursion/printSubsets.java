package recursion;

public class printSubsets {
	
	public static void main(String args[]) {
		subsets("ab","");
	}
	
	public static void subsets(String ip,String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		String op1=op;
		String op2=op+ip.charAt(0);
		String ip1=ip.substring(1);
		subsets(ip1,op1);
		subsets(ip1,op2);
		return;
	}

}
