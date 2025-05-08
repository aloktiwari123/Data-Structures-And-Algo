package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PunishmentNumber {

	static List<Integer> ansList;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(punishmentNo(37));
	}
	
	public static int punishmentNo(int n) {
		// TODO Auto-generated method stub
		int ans=0;
		for(int i=1;i<=n;i++) {
			ansList=new ArrayList<>();
			int square=i*i;
 			solve(String.valueOf(square),0);
			if(ansList.contains(i)) {
				ans+=square;
			}
		}
		return ans;
	}
	
	public static int getSum(List<Integer>list){
		return list.stream().reduce(0,(s1,s2)->s1+s2);	
	}
	
	public static void solve(String ip,int sum) {
		if(ip=="") {
			ansList.add(sum);
		}
		
		for(int k=0;k<ip.length();k++) {
			String ip1=ip.substring(0,k+1);
			String ip2=ip.substring(k+1,ip.length());
			//list.add(Integer.valueOf(ip1));
			sum+=Integer.valueOf(ip1);
			solve(ip2,sum);
			//list.remove(list.size()-1);
			sum-=Integer.valueOf(ip1);
		}
	}

}
