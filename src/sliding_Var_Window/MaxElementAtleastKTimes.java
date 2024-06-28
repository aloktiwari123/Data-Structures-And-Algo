package sliding_Var_Window;

public class MaxElementAtleastKTimes {

	public static void main(String args[]) {
		int[] nums = {61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82};
		int k = 2;
		System.out.print(solve(nums,k));
	}
	
	public static int solve(int[] arr,int k) {
		int i=0;
		int j=0;
		int max=0;
		for(i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		i=0;
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
				ans+=1;
				while(count>=k) {
					if(arr[i]==max) {
						count--;
					}
					i++;
					ans+=1;
				}
				j++;
			}
			
		}
		
		return ans;
	}
}
