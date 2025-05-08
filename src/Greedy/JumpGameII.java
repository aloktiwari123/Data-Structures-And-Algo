package Greedy;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,1};
		System.out.print(solve(arr,0,0));
	}

	// recursion logic
	public static int solve(int[] arr,int idx,int count) {
		if(idx>=arr.length-1) {
			return count;
		}
		int min=Integer.MAX_VALUE;
		if(arr[idx]==0) {
			return min;
		}
		for(int i=1;i<=arr[idx];i++) {
			min=Math.min(min,solve(arr,idx+i,count+1));
		}
		return min;
	}
}
