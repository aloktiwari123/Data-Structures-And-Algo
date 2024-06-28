package BackTracking;
import java.util.*;
public class NDigtNumbersWithIncDigitOrder {
	
	public static void main(String args[]) {
		int n=2;
		//solve(n,"",0);
		List<Integer>res=new ArrayList<>();
		int[]  arr=new int[n];
		solveBt(arr,0,res);
		System.out.println(res);
		
	}
	
	public static void solveBt(int[] arr, int n,List<Integer>res) {

		if(n==arr.length) {
			res.add(num(arr));
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(n==0) {
				int temp=arr[n];
				arr[n]=i;
				solveBt(arr,n+1,res);
				arr[n]=temp;
			}
			else {
				if(i>arr[n-1]) {
					int temp=arr[n];
					arr[n]=i;
					solveBt(arr,n+1,res);
					arr[n]=temp;
				}
			}
			
		}
	}
	
	public static int num(int[]arr) {
		int num=0;
		for(int i=0;i<arr.length;i++) {
			num=num*10+arr[i];
		}
		return num;
	}
	
}

