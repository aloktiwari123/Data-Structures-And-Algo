package recursion;
// a1b2
/*
 * A1b2,A1B2,a1b2,a1B2
 */
public class permutationLetterCase {
	
	public static void main(String args[]) {
		solve("A1B2","");
	}
	
	public static void solve(String in,String op) {
		if(in.length()==0) {
			System.out.println(op);
			return;
		}
		String op1="";
		String op2="";
		char temp=in.charAt(0);
		if(Character.isDigit(temp))
		{
			op1=op+temp;
			in=in.substring(1);
			solve(in,op1);
		}
		else {
			op1=op+temp;
			temp=(char)(Character.isUpperCase(temp)?temp+32:temp-32);
			op2=op+temp;
			in=in.substring(1);
			solve(in,op1);
			solve(in,op2);
		}
		return;
		
	}

}
