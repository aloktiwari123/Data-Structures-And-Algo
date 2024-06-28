package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostHomecomingofaRobotinaGrid {

	public static void main(String[] args) {
		int[] startPos = {0, 0};
		int[] homePos = {1, 2};
		int[] rowCosts = {10,2,5};
		int[] colCosts = {10,6,1};
		List<choice>choices=new ArrayList<>();
		choices.add(new choice('U',-1,0));
		choices.add(new choice('D',1,0));
		choices.add(new choice('L',0,-1));
		choices.add(new choice('R',0,1)); 
		System.out.print(solve(startPos,homePos,rowCosts,colCosts,choices));
	}
	
	public static int solve(int[] startPos,int[] homePos,int[] rowCosts,int[] colCosts,List<choice> choices) {
		
		if(startPos[0]==homePos[0] && startPos[1]==homePos[1]) {
			return 0;
		}
		
		int min=Integer.MAX_VALUE;
		
		for(choice c:choices) {
			int newX=startPos[0]+c.dx;
			int newY=startPos[1]+c.dy;
			if(isValidChoice(newX,newY,startPos,homePos)) {
				if(startPos[0]!=newX) {
					startPos[0]=newX;
					min=Math.min(min,rowCosts[newX]+solve(startPos,homePos,rowCosts,colCosts,choices));
				}
				else {
					startPos[1]=newY;
					min=Math.min(min,colCosts[newY]+solve(startPos,homePos,rowCosts,colCosts,choices));
				}
			}
		}
		return min;
	}
	
	public static boolean isValidChoice(int x,int y,int []startPos,int[] homePos) {
		return x >= 0 && Math.abs(homePos[0]-x)<=Math.abs(homePos[0]-startPos[0]) && y>=0 && Math.abs(homePos[1]-y)<=Math.abs(homePos[1]-startPos[1]);
	}

}


