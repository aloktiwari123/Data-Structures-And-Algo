package stack;

import java.util.Stack;

public class RemoveAllOccOfSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "axxxxyyyyb";
		String part = "xy";
		System.out.println(solve(s, part));
	}
	
	public static String solve(String s,String part) {
		while(s!=s.replaceFirst(part,"")) {
			s=s.replaceFirst(part,"");
		}
		
		for(int i=0;i<10;i++) {
			System.out.println("i"+i);
			for(int j=0;j<10;j++) {
				if(j>=i) break;
				System.out.print("j"+j);
			}
			System.out.println();
		}
		return s;
	}
	
	
	
	

}
