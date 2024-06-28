package recursion;

public class permutationWithCaseChange {
	public static void main(String args[]) {
		String s="ab";
		Solve(s,"");
	}
	
	public static void Solve(String ip,String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		
		String op1=op+ip.charAt(0);
		String op2=op+(char)(ip.charAt(0)-32);
		ip=ip.substring(1);
		Solve(ip,op1);
		Solve(ip,op2);
		return;
	}

}
