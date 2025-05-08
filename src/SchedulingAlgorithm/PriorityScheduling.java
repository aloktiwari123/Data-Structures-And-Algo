package SchedulingAlgorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Process>processes=new LinkedList<Process>() {{
			add(new Process("P1",0,2,10));
			add(new Process("P2",1,4,5));
			add(new Process("P3",2,1,15));
		}};
		System.out.print(runPriorityScheduling(processes));
	}

	private static LinkedList<Process> runPriorityScheduling(Queue<Process> processes) {
		// TODO Auto-generated method stub
		PriorityQueue<Process> readyQueue=new PriorityQueue<>((a,b)->b.priority-a.priority);
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
