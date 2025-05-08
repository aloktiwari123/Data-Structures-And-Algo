package SchedulingAlgorithm;

public class Process{
	String name;
	int arrivalTime;
	int burstTime;
	int completionTime;
	int turnaroundTime;
	int waitingTime;
	int remainingTime;
	int priority=0;
	
	public Process(String name,int arrivalTime,int burstTime) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.arrivalTime=arrivalTime;
		this.burstTime=burstTime;
		this.remainingTime=burstTime;
	}
	
	// constructor overloading
	public Process(String name,int arrivalTime,int burstTime,int priority) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.arrivalTime=arrivalTime;
		this.burstTime=burstTime;
		this.remainingTime=burstTime;
		this.priority=priority;
	}

	@Override
	public String toString() {
		return "Process [name=" + name + ", arrivalTime=" + arrivalTime + ", burstTime=" + burstTime
				+ ", completionTime=" + completionTime + ", turnaroundTime=" + turnaroundTime + ", waitingTime="
				+ waitingTime + ", remainingTime=" + remainingTime + "]";
	}

	
	
	
}
