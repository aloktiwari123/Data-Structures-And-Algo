package DynamicPrograming;

import java.util.HashSet;

public class UniqueSubstrings {
	
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ababccc";
		solve(s,0,new HashSet<String>());
		System.out.print(max);
		

	}
	
	public static void solve(String s,int i,HashSet<String>set) {
		if(i==s.length()) {
			max=Math.max(max,set.size());
			return;
		}
		
		for(int j=i;j<s.length();j++) {
			String temp=s.substring(i,j+1);
			if(!set.contains(temp)) {
				//HashSet<String>tempSet=new HashSet<>(set);
				set.add(temp);
				solve(s,j+1,set);
				set.remove(temp);
			}
			
		}
		
	}

}
