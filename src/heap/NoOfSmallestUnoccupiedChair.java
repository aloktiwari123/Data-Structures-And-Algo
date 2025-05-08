package heap;

import java.util.Arrays;

public class NoOfSmallestUnoccupiedChair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] times = {{1,4},{2,3},{4,6}};
		int targetFriend = 1;
		System.out.print(solve(times,targetFriend));

	}
	
	public static int solve(int[][] times,int target) {
		int[] targetTime=times[target];
		Arrays.sort(times,(a,b)->(a[0]-b[0]));
		int[] chairs=new int[times.length];
		for(int[] time:times) {
			int arrTime=time[0];
			int depTime=time[1];
			for(int i=0;i<chairs.length;i++) {
				if(chairs[i]<=arrTime) {
					chairs[i]=depTime;
					if(Arrays.equals(time,targetTime)) return i;
					break;
				}
			}
		}
		return 0;
	}

}
