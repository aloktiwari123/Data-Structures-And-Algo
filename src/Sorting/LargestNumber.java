package Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {34323,3432};
		solve(nums);
		
	}
	
	public static String solve(int[] nums) {
		PriorityQueue<Integer>pq=new PriorityQueue<>(new customCompare());
		for(int n:nums) {
			pq.add(n);
		}
		String s="";
		while(!pq.isEmpty()) {
			System.out.println(pq.peek());
			s+=pq.poll();
		}
		System.out.println(s);
		return s;
	}

}

class customCompare implements Comparator<Integer>{

	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		String s1=o1.toString();
		String s2=o2.toString();
		if(s1.length()==s2.length()) {
			for(int i=0;i<s1.length();i++) {
				int val1=(int)(s1.charAt(i)-'0');
				int val2=(int)(s2.charAt(i)-'0');
				if(val1>val2) {
					return -1;
				}else if(val2>val1) {
					return 1;
				}else {
					continue;
				}
			}
			return 0;
		}
		else if(s1.length()!=s2.length()) {
			int len=s1.length()<s2.length()?s1.length():s2.length();
			int i=0;
			for(i=0;i<len;i++) {
				int val1=(int)(s1.charAt(i)-'0');
				int val2=(int)(s2.charAt(i)-'0');
				if(val1>val2) {
					return -1;
				}else if(val2>val1) {
					return 1;
				}else {
					continue;
				}
			}
			if(len==s1.length()) {
				int val=(int)(s2.charAt(i)-'0');
				int last=(int)(s2.charAt(i-1)-'0');
				return val>last?1:-1;
			}else {
				int val=(int)(s1.charAt(i)-'0');
				int last=(int)(s1.charAt(i-1)-'0');
				return val>last?-1:1;
			}
		}
		return 0;
		
	}
	
}
