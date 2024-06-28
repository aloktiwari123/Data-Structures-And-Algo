package heap;
import java.util.*;
public class MaximizeHappinessofSelectedChildren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] happiness = {1,2,3};
		int k = 2;
		System.out.print(solve(happiness,k));
	}
	
	 public static long solve(int[] arr,int k) {
			Arrays.sort(arr);
			long c=0;
	        int max=arr.length-1;
			for(int i=arr.length-1;i>=arr.length-1-k;i--) {
				c+=arr[i]+(i-max)>=0?arr[i]+(i-max):0;
			}
			return c;
		}

}
