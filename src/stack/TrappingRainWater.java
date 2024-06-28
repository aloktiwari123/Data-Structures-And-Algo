package stack;

public class TrappingRainWater {
	
	public static void main(String args[]) {
		int[] arr= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.print(solve(arr));
	}
	
	public static int solve(int[] arr) {
		int[] maxL=new int[arr.length];
		int[] maxR=new int[arr.length];
		maxL[0]=arr[0];
		for(int i=1;i<arr.length;i++) {
			maxL[i]=Math.max(maxL[i-1],arr[i]);
		}
		maxR[arr.length-1]=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			maxR[i]=Math.max(maxR[i+1],arr[i]);
		}
		int water=0;
		for(int i=0;i<arr.length;i++) {
			water+=Math.min(maxL[i],maxR[i])-arr[i];
		}
		return water;
	}
	
}
