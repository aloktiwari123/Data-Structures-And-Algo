package sliding_Window;

public class MinOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("WBWBBBW", 2));
	}
	
	public static int solve(String blocks,int k) {
		int j=0;
		int i=0;
		char[] arr=blocks.toCharArray();
		int count=0;
		int ans=Integer.MAX_VALUE;
		while(j<arr.length) {
			if(arr[j]=='W') count++;
			
			if((j-i+1)<k) {
				j++;
			}else if((j-i+1)==k) {
				ans=Math.min(count, ans);
				if(arr[i]=='W') {
					count=count-1;
				}
				i++;
				j++;
			}
		}
		return ans;
	}

}
