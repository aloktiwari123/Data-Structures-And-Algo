package sliding_Window;
import java.util.*;
public class firstNegNumInWin {
	public static void first_NegNumInWin(int[] arr,int k) {
		Queue<Integer> queue=new LinkedList<>();
		int i=0,j=0;
		while(j<arr.length) {
			if(arr[j]<0) {
				queue.add(arr[j]);
			}
			if((j-i+1)<k) {
				j++;	
			}
			else if((j-i+1)==k) {
				if(queue.isEmpty()) {
					System.out.println(0);
					
				}
				else {
					System.out.println(queue.peek());
					if(queue.peek() == arr[i]) {
						queue.remove();
					}	
				}
				i++;
				j++;
				
			}
			
		}
		
	}
	public static void main(String args[]) {
		int [] arr= {12,-1,-7,8,-15,30,17,28};
		first_NegNumInWin(arr,3);
		
	}

}
