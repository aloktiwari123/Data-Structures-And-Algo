package BackTracking;
import java.util.*;
public class AllPermutation {

	public static void main(String args[]) {
		List<String> list=new ArrayList<>();
		String s="abc";
		//solve(s,"",list);
		solve_BT(s,0,list);
		System.out.print(list);
	}
	
	// Recursive Solution
	public static void solve(String s,String op,List<String>list){
		if(s.length()==0) {
			list.add(op);
			return;
		}
		HashSet<Character>set=new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!set.contains(ch)) {
				set.add(ch);
				String ip=s.substring(0,i)+s.substring(i+1);
				solve(ip,op+ch,list);
			}
		}
		
	}
	
	// BackTracking
	public static void solve_BT(String s,int idx,List<String>list) {
		if(idx==s.length()-1) {
			list.add(s);
			return;
		}
		HashSet<Character>set=new HashSet<>();
		for(int i=idx;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!set.contains(ch)) {
				set.add(ch);
				s=swap(idx,i,s);
				solve_BT(s,idx+1,list);
				s=swap(idx,i,s);
			}

		}
	}
	
	public static String swap(int i,int j,String s) {
		char[] arr=s.toCharArray();
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		return String.valueOf(arr);
	}
}
