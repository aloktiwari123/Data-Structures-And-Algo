package recursion;
import java.util.*;

// leetcode :1239

public class MaxLengthString {
	public static void main(String args[]) {
		String[] arr= {"aa","bb"};
		System.out.print(solve("",0,arr));
	}
	
	public static int solve(String op,int i,String[] arr) {
		if(i==arr.length) {
			return op.length();
		}
		if(isUnique(op,arr[i])) {
			return Math.max(solve(op+arr[i],i+1,arr),solve(op,i+1,arr));
		}
		else {
			return solve(op,i+1,arr);
		}
	}
	
	public static boolean isUnique(String s1,String s2) {
		HashSet<Character>set=new HashSet<>();

        for(char ch:s2.toCharArray()){
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
            
            if(s1.indexOf(ch)!=-1) {
            	return false;
            }
        }
		return true;
	}

}
