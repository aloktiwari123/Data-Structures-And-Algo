package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrayCode {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solve(3));
		
	}
	
	public static List<Integer> solve(int n){
		List<String>list=new ArrayList<String>() {{
			add("");
		}};
		
		for(int i=1;i<=n;i++) {
			List<String> ans=new ArrayList<>();
			for(String bits:list) {
				ans.add("0"+bits);
			}
			Collections.reverse(list);
			for(String bits:list) {
				ans.add("1"+bits);
			}
			list=ans;
		}
		List<Integer>res=new ArrayList<Integer>();
		for(String bits:list) {
			res.add(bitsToInteger(bits.toCharArray()));
		}
		return res;
	}
	
	public static int bitsToInteger(char[] bits) {
		int c=0;
		int sum=0;
		for(int i=bits.length-1;i>=0;i--) {
			sum+=Math.pow(2,c)*(bits[i]-'0');
			c++;
		}
		return sum;
	}

}
