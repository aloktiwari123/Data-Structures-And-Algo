package recursion;
import java.util.*;
public class generateAllNbitString {
	
	public static void main(String args[]) {
        ArrayList<String> list=new ArrayList<>();
        ArrayList<String> list1=new ArrayList<>();
        solve("",0,0,3,list);
        solve_AV("",0,0,3,list1);
        System.out.println(list);
        System.out.println(list1);
        
        
    }
    
    public static void solve(String op,int one,int zero,int n,ArrayList<String>list) {
		if(n==0) {
		    list.add(op);
			return;
		}
		String op1="";
		String op2="";
		if(one==zero) {
			op1=op+'1';
			solve(op1,one+1,zero,n-1,list);
		}
		else {
			op1=op+'1';
			op2=op+'0';
			solve(op1,one+1,zero,n-1,list);
			solve(op2,one,zero+1,n-1,list);
		}
		return;
		
	}

    public static void solve_AV(String op,int one,int zero,int n,ArrayList<String>list) {
		if(n==0) {
		    list.add(op);
			return;
		}
		String op1="";
		op1=op+'1';
		solve(op1,one+1,zero,n-1,list);
		if(one>zero){
			String op2="";
			op2=op+'0';
			solve(op2,one,zero+1,n-1,list);
		}
		return;
		
	}
}
