package HashFunction;
import java.util.*;
public class ContainsAllBinaryCodesofSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="00110";
		int k=2;
		System.out.println(solve(s,k));
	}
	
	public static boolean solve(String s,int k) {
		int allBinaryNo=(int)Math.pow(2,k);
		HashMap<String,Integer>map=new HashMap<>();
		for(int i=0;i<=s.length()-k;i++) {
			String temp=s.substring(i,i+k);
			map.put(temp,map.getOrDefault(temp,0)+1);
			if(map.size()==allBinaryNo) {
				return true;
			}
		}
		return false;
		
	}

}
