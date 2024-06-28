package sliding_Window;
import java.util.*;
public class maxOFAllSubArray {
	
	public static void max_OfAllSubArray(int[] arr,int k) {
		Queue<Integer> maxQueue= new LinkedList<>();
		int i=0,j=0;
		int max=0;
		while(j<arr.length) {
			if(max<arr[j]) {
				max=arr[j];
			}
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				if(maxQueue.isEmpty()) {
					maxQueue.add(max);
				}
				if(maxQueue.peek() != max)
				{
					maxQueue.remove();
					maxQueue.add(max);
				}
				System.out.println(maxQueue);
				System.out.println(maxQueue.peek());
				if(arr[i]==maxQueue.peek()) {
					maxQueue.remove();
					max=0;
				}
				i++;
				j++;
			}
		}
		
	}
	
	public static void max_OfAllSubArray_PQ(int[] arr,int k) {
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a); 
		int i=0;
		int j=0;
		while(j<arr.length) {
			maxPQ.add(arr[j]);
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				System.out.println(maxPQ);
				System.out.println(maxPQ.peek());
				maxPQ.remove(arr[i]);
				i++;
				j++;
			}
		}
	}
	
	public static void main(String args[]) {
		int[] arr= {1,3,-1,-3,5,3,6,7};
		//int[] arr= {6,2,1,5};
		max_OfAllSubArray_PQ(arr,3);
	}

}
