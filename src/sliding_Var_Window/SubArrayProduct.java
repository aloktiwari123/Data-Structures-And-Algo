package sliding_Var_Window;

public class SubArrayProduct {
	
	public static void main(String args[]) {
		int[]nums = {10,5,2,6};
		int k =100;
		System.out.print(solve(nums,k));
	}
	
	public static int solve(int[] arr,int k) {
		int i=0;
		int j=0;
		int count=0;
		int mul=1;
		while(j<arr.length) {
			mul=mul*arr[j];
			
			if(mul<k) {
				count+=(j-i+1);
				j++;
			}
			else {
				while(mul>=k && i<arr.length) {
					mul=mul/arr[i];
					i++;
				}
				count+=(j-i+1);
				j++;
			}
		}
		return count;
	}

}
