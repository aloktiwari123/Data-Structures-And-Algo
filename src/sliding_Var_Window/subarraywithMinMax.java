package sliding_Var_Window;
import java.util.*;
public class subarraywithMinMax {
	
	public static void main(String args[]) {
		int[] arr= {1,3,5,2,7,5};
		int min=1;
		int max=5;
		System.out.print(solve(arr,min,max));
		System.out.print(solve(arr,min-1,max-1));
	}
	
	public static int solve(int[] arr,int min,int max) {
		int i=0;
		int j=0;
		int count=0;
		PriorityQueue<Integer> minPQ = new PriorityQueue<>((a,b) -> a - b);
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a);
		boolean isempt=false;
		while(j<arr.length) {
			minPQ.add(arr[j]);
			maxPQ.add(arr[j]);
			if(minPQ.peek() >= min && maxPQ.peek() <= max) {
				count+=(j-i+1);
				j++;
			}
			else if(minPQ.peek() < min || maxPQ.peek() > max) {
				while(minPQ.peek() < min || maxPQ.peek() > max)
				{
					minPQ.remove(arr[i]);
					maxPQ.remove(arr[i]);
					if(minPQ.isEmpty() || maxPQ.isEmpty()) {
						isempt=true;
						break;
					}
					i++;
				}
				if(!isempt) {
					count+=(j-i+1);
				}
				j++;
			}
		}
		return count;
		
	}

}
