package recursion;
import java.util.*;
public class NumberOfSteps {
	
	public static void main(String args[]) {
		System.out.println(getNumber("1101"));
		System.out.println(solve(13));
	}
	
	public static int solve(int n) {
		if(n==1) {
			return 0;
		}
		
		if(n%2==0) {
			return 1+solve(n/2);
		}
		else {
			return 1+solve(n+1);
		}
	}

	public static int getNumber(String s) {
		char[] chars=s.toCharArray();
		int n=0;
		int c=0;
		for(int i=chars.length-1;i>=0;i--) {
			n=n+(chars[i]-'0')*(int)Math.pow(2,c);
			c++;
		}
		return n;
	}
	
}
