package Greedy;

import java.util.Arrays;

public class ShortestJobFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] process= {4,3,7,1,2};
		System.out.print(solve(process));
	}
	
	public static int solve(int[] processes) {
		int time=0;
		int waitingTime=0;
		Arrays.sort(processes);
		for(int process:processes) {
			waitingTime+=time;
			time+=process;
		}
		return waitingTime/processes.length;
	}

}
