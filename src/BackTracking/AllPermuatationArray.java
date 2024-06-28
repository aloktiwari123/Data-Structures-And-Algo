package BackTracking;
import java.util.*;
public class AllPermuatationArray {

	public static void main(String args[]) {
		List<List<Integer>>list=new ArrayList<>();
		int[] nums= {1,2,3};
		solve(0,nums,list);
		System.out.print(list);
	}
	
	public static void solve(int idx,int[] arr,List<List<Integer>>list){
		if(idx==arr.length) {
			list.add(toList(arr));
			return;
		}
		HashSet<Integer>set=new HashSet<>();
		for(int i=idx;i<arr.length;i++) {
			if(!set.contains(arr[i])) {
				set.add(arr[i]);
				swap(idx,i,arr);
				solve(idx+1,arr,list);
				swap(idx,i,arr);
			}
		}
	}
	
	public static void swap(int i,int j,int[] arr){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static List<Integer> toList(int[] nums){
		List<Integer>arr=new ArrayList<>();
		for(int i  :nums) {
			arr.add(i);
		}
		return arr;
	}
}
