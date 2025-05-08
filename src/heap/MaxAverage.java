package heap;

import java.util.PriorityQueue;

public class MaxAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] classes = {{1,2},{3,5},{2,2}};
		int extraStudents = 2;
		System.out.print(maxAverage(classes,extraStudents));
	}
	
	public static double maxAverage(int[][] classes,int extraStudent) {
		PriorityQueue<double []> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
		
		for(int[] cls:classes) {
			pq.add(new double[] {calGain(cls[0],cls[1]),cls[0],cls[1]});
		}
		
		while(extraStudent-- >0) {
			double[] curr=pq.poll();
			pq.add(new double[] {calGain(curr[1],curr[2]),curr[1]+1,curr[2]+1});
		}
		
		double finalRatio=0;
		
		while(!pq.isEmpty()) {
            double[] current = pq.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            finalRatio += (double) passes / totalStudents;
		}
		return finalRatio/classes.length;
	}
	
	public static double calGain(double passes,double total) {
		return ((double)(passes+1)/(total+1)-(double)(passes/total));
	}

}
