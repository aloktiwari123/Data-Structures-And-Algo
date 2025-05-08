package sliding_Var_Window;

public class SubarrayWithScoreLessThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,1,4,3,5};
		int k = 10;
		System.out.println(solve(nums, k));
	}
	
	public static int solve(int[] arr,int k) {
		int i=0;
		int j=0;
		int sum=0;
		int count=0;
		
		while(j<arr.length) {
			sum+=arr[j];
			if(sum*(j-i+1)<k) {
				count+=(j-i+1);
				j++;
			}else if(sum*(j-i+1)>=k) {
				while(sum*(j-i+1)>=k) {
					sum-=arr[i];
					i++;
				}
				count+=(j-i+1);
				j++;
			}
		}
		return count;
	}

}
