package recursion;
import java.util.*;
public class CountVowelPermutation {
	
	public static void main(String args[]) {
		char[] arr= {'a','e','i','o','u'};
		List<String>list=new ArrayList<>();
		solve(5,0,arr,"",list);
		System.out.println(list);
		System.out.println(list.size());
	}
	
	public static void solve(int n,int idx,char[] ip,String op,List<String>list){
		if(idx==n) {
			list.add(op);
			return;
		}
		
		for(int i=0;i<ip.length;i++)
		{
			char ch=ip[i];
			solve(n,idx+1,decison(ch),op+ch,list);
		}
		
	}
	
	public static char[] decison(char ch) {
		if(ch=='a') {
			return new char[] {'e'};
		}
		else if(ch=='e') {
			return new char[] {'a','i'};
		}
		else if(ch=='i') {
			return new char[] {'a','e','o','u'};
		}
		else if(ch=='o') {
			return new char[] {'i','u'};
		}
		else {
			return new char[] {'a'};
		}
	}

}
