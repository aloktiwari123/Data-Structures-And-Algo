package DynamicPrograming;

import java.util.*;

public class AllPalindromePartations {
	
	public static void main(String args[]) {
		String s="aab";
		System.out.print(solve(s,0,s.length()-1));
	}
	
	public static List<List<String>> solve(String s,int i,int j){
		List<List<String>>ans=new ArrayList<>();
		if((j-i+1)==1) {
			List<String>res=new ArrayList<>();
			res.add(s.substring(i,i+(j-i+1)));
			ans.add(res);
			return ans;
		}
		
		if(isPalin(s,i,j)) {
			List<String>res=new ArrayList<>();
			res.add(s.substring(i,i+(j-i+1)));
			ans.add(res);
			//return ans;
		}
		
		for(int k=i;k<j;k++) {
			List<List<String>>temp1=solve(s,i,k);
			List<List<String>>temp2=solve(s,k+1,j);
			for(List<String> t1:temp1) {
				for(List<String> t2:temp2) {
					List<String> temp=new ArrayList<>();
					temp.addAll(t1);
					temp.addAll(t2);
					if(!ans.contains(temp)) {
						ans.add(temp);
					}	
				}
			}
		}
		return ans;
	}
	
	public static boolean isPalin(String s,int i,int j) {
		if(i==j) {
			return true;
		}
		
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;		
	}

}
