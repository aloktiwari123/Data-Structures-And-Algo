package sliding_Var_Window;

public class LongestSubarrayAfterDeletingOne {
	public static void main(String args[]) {
		int[] arr= {1,1,1};
		System.out.print(solve(arr));
	}
	
	public static int solve(int[] arr) {
		int i=0;
		int j=0;
		int max=0;
		int max_freq=0;
		while(j<arr.length) {
			if(arr[j]==1) {
				max_freq+=1;
			}
			if(((j-i+1)-max_freq)<1) {
				j++;
			}
			else if(((j-i+1)-max_freq)==1){
				max=Math.max(max,(j-i+1));
				j++;
			}
			else if(((j-i+1)-max_freq)>1){
				while(((j-i+1)-max_freq)>1){
					if(arr[i]==1) {
						max_freq-=1;
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}

}
