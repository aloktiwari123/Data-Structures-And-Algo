package recursion;
import java.util.*;
public class generateParanthese {
	
	public static void main(String args[]) {
		List<String>list=new ArrayList<>();
		solve("",3,3,list);
		System.out.println(list);
	}
	
	public static void solve(String op,int o,int c,List<String> list)
	{
		if(o==0 && c==0) {
			list.add(op);
			return;
		}
		/*
		 * if we have open bracket we can always take them
		 */
		if(o!=0) {
			String op1=op+'(';
			solve(op1,o-1,c,list);
		}
		/*
		 * if closed is greater than open we can select close
		 */
		if(c>o) {
			String op2=op+')';
			solve(op2,o,c-1,list);
		}
		return;
	}
	
	
}
