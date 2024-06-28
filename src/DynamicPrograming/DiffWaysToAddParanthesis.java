package DynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToAddParanthesis {

	public static void main(String args[]) {
		String s="2*3-4*5";
		System.out.print(solve(s,0,s.length()-1));
	}
	
	public static List<Integer> solve(String s,int i,int j) {
		List<Integer>ans=new ArrayList<>();
		if((j-i+1)<=2) {
			String temp=s.substring(i,i+(j-i+1));
			ans.add(Integer.valueOf(temp));
			return ans;
		}
		
		for(int k=i;k<j;k++) {
			char ch = s.charAt(k);
	        if(ch == '-' || ch == '+' || ch == '*')
	        {
	        	List<Integer> temp1=solve(s,i,k-1);
				List<Integer> temp2=solve(s,k+1,j);
				for (int l : temp1) {
                    for (int r : temp2) {
                        if (ch == '+') {
                            ans.add(l + r);
                        } else if (ch == '-') {
                        	ans.add(l - r);
                        } else if (ch == '*') {
                        	ans.add(l * r);
                        }
                    }
                }
		
	        }
			
		}
		return ans;
	}
	
}
