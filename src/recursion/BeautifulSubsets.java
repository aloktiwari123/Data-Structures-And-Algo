package recursion;
import java.util.*;
public class BeautifulSubsets {

	static int count;
	static List<List<Integer>>adj=new ArrayList<>();
	public static void main(String args[]) {
		int[] nums = {1};
		int k = 1;
		Arrays.sort(nums);
		System.out.println(solve(new ArrayList<>(),nums,0,k));
		System.out.println(count);
		System.out.println(adj);
	}
	
	public static int solve(ArrayList<Integer> list,int [] arr, int idx,int k) {
		if(idx==arr.length) {
			adj.add(list);
			count=list.size()>0?count+1:count;
			return list.size()>0?1:0;
		}
		
		int curr=arr[idx];
		int taken=0;
		if(isValid(list,curr,k)) {
			ArrayList<Integer> op1=new ArrayList<>(list);
			op1.add(curr);
			taken=solve(op1,arr,idx+1,k);
		}
		int notTaken=solve(list,arr,idx+1,k);
		return taken+notTaken;
	}
	
	public static boolean isValid(ArrayList<Integer> list,int curr,int k) {
		return list.size()==0?true:Math.abs(list.get(list.size()-1)-curr)!=k?true:false;
	}
	
	
//	public static void solve(ArrayList<Integer> list,int [] arr, int idx,int k) {
//		if(idx==arr.length) {
//			adj.add(list);
//			return;
//		}
//		
//		for(int i=idx;i<arr.length;i++) {
//			int curr=arr[i];
//			if(isValid(list,curr,k)) {
//				ArrayList<Integer> op1=new ArrayList<>(list);
//				op1.add(curr);
//				solve(op1,arr,idx+1,k);
//			}
//		}
//		return;
//	}
	
	
}
