package recursion;

import java.util.ArrayList;
import java.util.List;

public class eliminateGame {
	public static void main(String args[]) {
		int n=9;
		List<Integer>list=new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		System.out.println(solve(list,0));
	}
	
	public static int solve(List<Integer>list,int status) {
		if(list.size()==1) {
			return list.get(0);
		}
		List<Integer>remove=new ArrayList<>();
		if(status==0) {
			for(int i=0;i<list.size();i=i+2) {
				remove.add(list.get(i));
			}
			list.removeAll(remove);
			return solve(list,1);
		}
		else {
			for(int i=list.size()-1;i>=0;i=i-2) {
				remove.add(list.get(i));
			}
			list.removeAll(remove);
			return solve(list,0);
			
		}
		
	}
	

}
