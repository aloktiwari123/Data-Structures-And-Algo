package binarySearch;

import java.util.*;
import java.util.Comparator;

public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solve());
		String s=(String)null;
		System.out.print(s==null?true:false);
	}
	
	public static int solve() {
		int[] difficulty = {68,35,52,47,86};
		int[] profit = {67,17,1,81,3};
		int[] worker = {92,10,85,84,82};
		int[][] map=new int[profit.length][2];
		for(int i=0;i<profit.length;i++) {
			map[i]=new int[] {difficulty[i],profit[i]};
		}
		Arrays.sort(map,new Comparator<int[]>() {
		     @Override
		     public int compare(int[] o1, int[] o2) {
		         int result = Integer.compare(o1[0], o2[0]);
		         if (result == 0) {
		             result = Integer.compare(o2[1], o1[1]);
		         }
		         return result;
		     }});
		for(int i=0;i<profit.length-1;i++) {
			map[i+1][1]=Math.max(map[i+1][1],map[i][1]);
		}
		int sum=0;
		for(int i=0;i<worker.length;i++) {
			//sum+=search(map,worker[i]);
			int[] data=search(map,worker[i]);
			if(data[0]>worker[i]) {
				data[1]=0;
			}
			sum+=data[1];
		}
		return sum;
	}
	
	public static int[] search(int[][] diff,int k) {
		int low=0;
		int high=diff.length-1;
		int mid=0;
		int res=0;
		while(low<=high) {
			mid=low+(high-low)/2;
			
			if(diff[mid][0]==k) {
				return diff[mid];
			}
			else if(diff[mid][0]>k) {
				high=mid-1;
			}
			else if(diff[mid][0]<k) {
				res=mid;
				low=mid+1;
			}
		}
		return diff[res];
	}

}


