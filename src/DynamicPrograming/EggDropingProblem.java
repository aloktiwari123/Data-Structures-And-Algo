package DynamicPrograming;
import java.util.*;
public class EggDropingProblem {
	
	static HashMap<String,Integer>map=new HashMap<>();
	public static void main(String args[]) {
		System.out.println(solve(2,100));
	}
	
	public static int solve(int e,int f) {
		if(f==0 || f==1) {
			return f;
		}
		
		if(e==1) {
			return f;
		}
		
		String key=e+"|,|"+f;
		if(map.containsKey(key)) {
			return map.get(key);
		}
		int mn=Integer.MAX_VALUE;
		
		for(int k=1;k<=f;k++) {
			//egg broke
			int eggBroke=solve(e-1,k-1);
			//egg does not broke
			int eggNotBroke=solve(e,f-k);
			int temp=1+Math.max(eggBroke,eggNotBroke);
			mn=Math.min(mn,temp);
		}
		map.put(key,mn);
		return mn;
	}

}
