package sliding_Var_Window;

public class MaxElementAtleastKTimes {

	public static void main(String args[]) {
		//int[] nums = {61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82};
		int[] nums = {1,3,2,3,3};
		int k = 2;
		int max=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max) {
				max=nums[i];
			}
		}
		System.out.print(solve(nums,k,max));
	}
	
	public static int solve(int[] arr,int k,int max) {
		int i=0;
		int j=0;
		int count=0;
		int ans=0;
		while(j<arr.length) {
			if(arr[j]==max) {
				count++;
			}
			if(count<k) {
				j++;
			}
			else if(count>=k) {
				//ans+=(j-i+1);
				while(count>=k) {
					if(arr[i]==max) {
						count--;
					}
					ans+=(j-i+1);
					i++;
				}
				j++;
			}
			
		}
		
		return ans;
	}
}
