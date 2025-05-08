package SchedulingAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class PreemptiveSJF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Process>processes=new LinkedList<Process>() {{
			add(new Process("P1",0,2));
			add(new Process("P2",1,4));
			add(new Process("P3",2,1));
		}};
		System.out.print(runSJF(processes));
	}

	private static LinkedList<Process> runSJF(Queue<Process> processes) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
