package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartionining {

	static List<List<String>>ans=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaba";
		solve(s,new ArrayList<>());
		System.out.print(ans);
	}
	
	public static boolean isPalin(String s) {
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
		}
		return true;
	}

	 //approach 1
	public static void solve(String ip,List<String> list) {
		if(ip.equals("")) ans.add(new ArrayList<>(list));
		
		for(int k=0;k<ip.length();k++) {
			String s1=ip.substring(0,k+1);
			String s2=ip.substring(k+1,ip.length());
			if(isPalin(s1)) {
//				List<String>temp= new ArrayList<>(list);
//				temp.add(s1);
//				solve(s2,temp);
				list.add(s1);
				solve(s2,list);
				list.remove(s1);
			}
		}
	}
	
	// approach 2
//	public static void solve(String s,int idx,List<String> list) {
//		if(idx==s.length()) ans.add(new ArrayList<>(list));
//		
//		for(int k=idx;k<s.length();k++) {
//			String s1=s.substring(idx,idx+k+1);
//			if(isPalin(s1)) {
////				List<String>temp= new ArrayList<>(list);
////				temp.add(s1);
////				solve(s2,temp);
//				list.add(s1);
//				solve(s,k,list);
//				list.remove(list.size()-1);
//			}
//		}
//	}
}
