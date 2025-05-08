package SchedulingAlgorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Shortest Job First (SJF)
 * The process with the shortest execution time is scheduled first.
 */
public class SJF {

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
		PriorityQueue<Process> readyQueue=new PriorityQueue<>((a,b)->a.burstTime-b.burstTime);
		LinkedList<Process>finisheQueueProcesses=new LinkedList<>();
		int currentTime=0;
		while(!processes.isEmpty()) {
			readyQueue.add(processes.poll());
		}
		
		while(!readyQueue.isEmpty()) {
		Process process=readyQueue.poll();
		currentTime=Math.max(currentTime,process.arrivalTime);
		process.completionTime=currentTime+process.burstTime;
		process.turnaroundTime=process.completionTime-process.arrivalTime;
		process.waitingTime=process.turnaroundTime-process.burstTime;
		currentTime=process.completionTime;
		finisheQueueProcesses.add(process);
		}
		return finisheQueueProcesses;
	}

}

