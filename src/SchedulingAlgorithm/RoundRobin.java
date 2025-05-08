package SchedulingAlgorithm;

import java.net.PortUnreachableException;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Advantages of Round Robin Scheduling
Fairness: Each process gets an equal share of the CPU.
Simplicity: The algorithm is straightforward and easy to implement.
Responsiveness: Round Robin can handle multiple processes without significant delays, making it ideal for time-sharing systems.


* Disadvantages of Round Robin Scheduling:
Overhead: Switching between processes can lead to high overhead, especially if the quantum is too small.
Underutilization: If the quantum is too large, it can cause the CPU to feel unresponsive as it waits for a process to finish its time.
 */

public class RoundRobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Process>processes=new LinkedList<Process>() {{
			add(new Process("P1",0,2));
			add(new Process("P2",1,4));
			add(new Process("P3",2,1));
		}};
		System.out.print(runRR(processes,2));
	}

	private static LinkedList<Process> runRR(Queue<Process> processes,int quantum) {
		// TODO Auto-generated method stub
		Queue<Process>readyQueue=new LinkedList<>();
		LinkedList<Process>finishedProcesses=new LinkedList<>();
		
		for(Process process:processes) {
			if(process.arrivalTime==0) {
				readyQueue.offer(process);
			}
		}
		int currentTime=0;
		while(!readyQueue.isEmpty()) {
			Process currProcess=readyQueue.peek();
			currentTime=Math.max(currentTime,currProcess.arrivalTime);
			int executeTime=Math.min(quantum,currProcess.remainingTime);
			currProcess.remainingTime-=executeTime;
			currentTime+=executeTime;
			
			// add more process to ready state
			for(Process process:processes) {
				if(!readyQueue.contains(process) && !finishedProcesses.contains(process) && process.arrivalTime<=currentTime) {
					readyQueue.add(process);
				}
			}
			readyQueue.poll();
			// check if current process is completed or not
			if(currProcess.remainingTime>0) {
				readyQueue.offer(currProcess);
				// add back to the queue
			}else {
				currProcess.completionTime=currentTime;
				currProcess.turnaroundTime=currProcess.completionTime-currProcess.arrivalTime;
				currProcess.waitingTime=currProcess.turnaroundTime-currProcess.burstTime;
				finishedProcesses.add(currProcess);
				System.out.println(currProcess);
			}
		}
		return finishedProcesses;
	}
	

}
