package heap;

import java.util.PriorityQueue;

public class AmazonFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		int[] factor= {1,2,1};
		int x=2;
		System.out.print(solve(matrix,factor,x));
	}
	
	public static int solve(int[][]matrix,int[]factor,int x) {
		PriorityQueue<Integer>finalFactor=new PriorityQueue<>((a,b)->(b-a));
		int n=matrix.length;
		int m=matrix[0].length;
		if(factor.length>n) return -1;
		for(int i=0;i<n;i++) {
			PriorityQueue<Integer>temp=new PriorityQueue<>((a,b)->(b-a));
			for(int j=0;j<m;j++) {
				temp.add(matrix[i][j]);
			}
			int currFactor=factor[i];
			while(currFactor>0) {
				int no=temp.peek();
				finalFactor.add(no);
				temp.poll();
				currFactor--;
			}
		}
		if(x>finalFactor.size()) return -1;
		int ans=0;
		while(x>0) {
			ans+=finalFactor.poll();
			x--;
		}
		return ans;
	}

}
