package DynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelString {

	public static void main(String args[]) {
		char[] arr= {'a','e','i','o','u'};
		List<String>list=new ArrayList<>();
		solve(3,0,arr,"",list);
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
			return new char[] {'a','e','i','o','u'};
		}
		else if(ch=='e') {
			return new char[] {'e','i','o','u'};
		}
		else if(ch=='i') {
			return new char[] {'i','o','u'};
		}
		else if(ch=='o') {
			return new char[] {'o','u'};
		}
		else {
			return new char[] {'u'};
		}
	}
}
