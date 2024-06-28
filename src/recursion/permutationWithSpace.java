package recursion;

public class permutationWithSpace {
	
	public static void main(String args[]) {
		String s="bc";
		String op="a";
		Solve(s,op);
	}
	
	public static void Solve(String ip,String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		
		String op1=op+"_"+ip.charAt(0);
		String op2=op+ip.charAt(0);
		ip=ip.substring(1);
		Solve(ip,op1);
		Solve(ip,op2);
		return;
	}

}
