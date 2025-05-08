package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
		List<int[]> mergedList=new ArrayList<>();
		for(int i=0;i<intervals.length;i++) {
			
			if(mergedList.isEmpty() || mergedList.getLast()[1] < intervals[i][0]) {
				mergedList.add(intervals[i]);
			}else {
				mergedList.getLast()[1]=Math.max(intervals[i][1],mergedList.getLast()[1]);
			}
		}
		System.out.println(mergedList);
	}

}
