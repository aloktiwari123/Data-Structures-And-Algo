package Greedy;

public class EqualDomino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tops = {2,1,2,4,2,2};
		int[] bottoms = {5,2,6,2,3,2};
	}
	public static int solve(int[]tops,int[]bottoms) {
		int res=getNoOfRotations(tops, bottoms,tops[0]);
		if(tops[0]!=bottoms[0]) {
			res=Math.min(res, getNoOfRotations(tops, bottoms,bottoms[0]));
		}
		return res == Integer.MAX_VALUE?-1:res;
	}
	
	public static int getNoOfRotations(int[]tops,int[]bottoms,int target) {
		int bottom=0;
		int top=0;
		for(int i=0;i<tops.length;i++) {
			if(tops[i]!=target && bottoms[i]!=target) {
				return Integer.MAX_VALUE;
			}
			if(tops[i]!=target) top++;
			if(bottoms[i]!=target) bottom++;
		}
		return Math.min(top, bottom);
	}

}
