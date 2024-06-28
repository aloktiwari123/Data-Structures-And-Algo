package DynamicPrograming;
import java.util.*;
public class DiffWaysToEvalExpression {
	
	static HashMap<String,Integer>map=new HashMap<>();
	public static void main(String args[]) {
		String s="T^F&T";
		System.out.println(solve(s,0,s.length()-1,true));
		System.out.println(solveMemo(s,0,s.length()-1,true));
	}
	
	public static int solve(String s,int i,int j,boolean isTrue) {
		int ans=0;
//		if((j-i+1)==1) {
//			if(isTrue) {
//				return s.charAt(i)=='T'?1:0;
//			}
//			else {
//				return s.charAt(i)=='F'?1:0;
//			}
//		}
		
		if(i>j) {
			return 0;
		}
		
		if(i==j) {
			if(isTrue) {
				return s.charAt(i)=='T'?1:0;
			}
			else {
				return s.charAt(i)=='F'?1:0;
			}
		}
		
		for(int k=i+1;k<=j-1;k++) {
			int lT=solve(s,i,k-1,true);
			int lF=solve(s,i,k-1,false);
			int rT=solve(s,k+1,j,true);
			int rF=solve(s,k+1,j,false);
			
			char ch=s.charAt(k);
			if(ch=='&') {
				if(isTrue) {
					ans=ans+(lT*rT);
				}else {
					ans=ans+(lT*rF+lF*rF+lF*rT);
				}
				
			}else if(ch=='|') {
				if(isTrue) {
					ans=ans+(lT*rF+lT*rT+lF*rT);
				}else {
					ans=ans+(lF*rF);
				}
				
			}else if(ch=='^') {
				if(isTrue) {
					ans=ans+(lF*rT+lT*rF);
				}else {
					ans=ans+(lF*rF+lT*rT);
				}
			}
		}
		return ans;
	}

	public static int solveMemo(String s,int i,int j,boolean isTrue) {
		int ans=0;		
		if(i>j) {
			return 0;
		}
		
		if(i==j) {
			if(isTrue) {
				return s.charAt(i)=='T'?1:0;
			}
			else {
				return s.charAt(i)=='F'?1:0;
			}
		}
		
		String key=i+"|,|"+j+"|,|"+isTrue;
		
		if(map.containsKey(key)) {
			return map.get(key);
		}
		
		for(int k=i+1;k<=j-1;k++) {
			int lT=solveMemo(s,i,k-1,true);
			int lF=solveMemo(s,i,k-1,false);
			int rT=solveMemo(s,k+1,j,true);
			int rF=solveMemo(s,k+1,j,false);
			
			char ch=s.charAt(k);
			if(ch=='&') {
				if(isTrue) {
					ans=ans+(lT*rT);
				}else {
					ans=ans+(lT*rF+lF*rF+lF*rT);
				}
				
			}else if(ch=='|') {
				if(isTrue) {
					ans=ans+(lT*rF+lT*rT+lF*rT);
				}else {
					ans=ans+(lF*rF);
				}
				
			}else if(ch=='^') {
				if(isTrue) {
					ans=ans+(lF*rT+lT*rF);
				}else {
					ans=ans+(lF*rF+lT*rT);
				}
			}
		}
		map.put(key,ans);
		return ans;
	}
}
