package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinTimeToReachLastRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] moveTime = {{0,0,0},{0,0,0}};
		int n=moveTime.length;
		int m=moveTime[0].length;
		int[][] minTime = new int[n][m];
		for(int[] time:minTime) {
			Arrays.fill(time,Integer.MAX_VALUE);
		}
		System.out.print(getMinTime(moveTime,minTime,n,m));
	}
	
	public static boolean isValid(int i,int j,int n,int m) {
		return (i>=0 && i<n && j>=0 && j<m);
	}
	
	public static int getMinTime(int[][] moveTime,int[][] minTime,int n,int m) {
		PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
		pq.add(new int[] {0,0,0});
		minTime[0][0]=0;
		int[][] moves= {{0,1},{0,-1},{1,0},{-1,0}};
		
		while(!pq.isEmpty()) {
			int[] curr=pq.poll();
			int x=curr[1];
			int y=curr[2];
			for(int[] move:moves) {
				int newX=x+move[0];
				int newY=y+move[1];
				if(isValid(newX,newY,n,m)) {
					int newTime=Math.max(minTime[x][y],moveTime[newX][newY]);
					if(newTime+1<minTime[newX][newY]) {
						minTime[newX][newY]=newTime+1;
						pq.add(new int[] {minTime[newX][newY],newX,newY});
					}
				}
				
			}
		}
		return minTime[n-1][m-1];
	}

}
