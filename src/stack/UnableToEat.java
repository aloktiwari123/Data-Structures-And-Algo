package stack;
import java.util.*;
public class UnableToEat {

	public static void main(String args[]) {
		int[] students = {1,1,1,0,0,1};
		int[] sandwiches = {1,0,0,0,1,1};
		System.out.print(solve(students,sandwiches));
	}
	
	public static int solve(int[] st,int[] sd) {
		Stack<Integer> stack=new Stack<>();
		Queue<Integer> queue=new LinkedList<>();
		int[] li={0,0};
		for(int i:st) {
			if(i==1) {
				li[1]++;
			}
			else {
				li[0]++;
			}
			queue.add(i);
		}
		
		for(int i=sd.length-1;i>=0;i--) {
			stack.add(sd[i]);
		}
		
		while(!stack.isEmpty() &&  li[stack.peek()]!=0) {
			int student=queue.poll();
			if(student==stack.peek()) {
				li[stack.peek()]--;
				stack.pop();
			}
			else {
				queue.add(student);
			}
		}
		
		return queue.size();
		
	}
	
}