package HashFunction;

import java.util.HashSet;

public class LongestPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {10};
		int[] arr2 = {17,11};
		System.out.print(solve(arr1,arr2));
	}
	
	public static int solve(int[] arr1,int[] arr2) {
		HashSet<String>set=new HashSet<>();
		int count=0;
		for(int i=0;i<arr1.length;i++) {
			String s=String.valueOf(arr1[i]);
			for(int j=1;j<=s.length();j++) {
				String temp=s.substring(0,j);
				set.add(String.valueOf(temp));
			}
			
		}
		for(int i=0;i<arr2.length;i++) {
			String s=String.valueOf(arr2[i]);
			for(int j=1;j<=s.length();j++) {
				String temp=s.substring(0,j);
				if(set.contains(temp)) count++;
			}
		}
		return count;
	}

}
