package sliding_Var_Window;

public class MinSubArrayLen {
	
	public static void main(String args[]) {
		int[] arr= {2,3,1,2,4,3};
		 System.out.print(minSubArrayLen(7,arr));
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
		int i=0,j=0;
		int min=Integer.MAX_VALUE;
		int sum=0;
		while(j<nums.length) {
			sum=sum+nums[j];
			if(sum<target) {
				j++;
			}
			else if(sum>=target){
				while(sum>=target) {
					min=Math.min(min,(j-i+1));
					sum=sum-nums[i];
					i++;	
				}
				j++;	
			}
		}
        return min !=Integer.MAX_VALUE ?min:0;
    }
}
