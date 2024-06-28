package recursion;

import java.util.*;

public class safeSpace {
	
	public static void main(String args[]) {
		List<Integer>list=new ArrayList<>();
		int n=40;
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		int k=7;
		k=k-1;
		System.out.print(solve(list,k,0));
	}
	
	public static int solve(List<Integer>list,int k,int idx) {
		if(list.size()==1) {
			int temp=list.get(0);
			return temp;
		}
		idx=(idx+k)%list.size();
		list.remove(idx);
		return solve(list,k,idx);
	}

}
