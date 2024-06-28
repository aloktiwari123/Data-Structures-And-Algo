package sliding_Var_Window;
import java.util.*;
public class PalindromicSubstring {
	
	public static void main(String args[]) {
		String s="aaa";
		
		System.out.print(solve(s));
	}
	
	public static int solve(String s) {
		int i=0;
		int j=0;
		char[] arr=s.toCharArray();
		int count=0;
		while(j<arr.length) {
			if(isPalin(i,j,s)) {
				count+=(j-i+1);
				j++;
			}else {
				while(!isPalin(i,j,s)) {
					i++;
				}
				count+=(j-i+1);
				j++;
			}
		}
		return count;
	}
	
	public static boolean isPalin(int i,int j,String s) {
		String sub1=s.substring(i,j+1);
		String sub2="";
		for(char ch:sub1.toCharArray()) {
			sub2=ch+sub2;
		}
		return sub1.equals(sub2)?true:false;
	}

}
