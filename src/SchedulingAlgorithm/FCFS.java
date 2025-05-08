package SchedulingAlgorithm;
import java.util.LinkedList;
import java.util.Queue;

/*
 * First Come First Serve
 * Processes are executed in the order they arrive.
 */
public class FCFS {
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Process>processes=new LinkedList<Process>() {{
			add(new Process("P1",0,2));
			add(new Process("P2",1,4));
			add(new Process("P3",2,1));
		}};
		System.out.print(runFCFS(processes));
		
	}
	
	public static LinkedList<Process> runFCFS(Queue<Process>processes) {
		Queue<Process>readyQueue=new LinkedList<>(processes);
		LinkedList<Process>finisheQueueProcesses=new LinkedList<>();
		int currentTime=0;
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


