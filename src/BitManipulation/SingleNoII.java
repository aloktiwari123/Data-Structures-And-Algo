package BitManipulation;

public class SingleNoII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(new int[]{2,2,3,2}));
	}
	
	public static int solve(int[] nums) {
		int ans=0;
		for(int i=0;i<=31;i++) {
			int cnt=0;
			for(int num:nums) {
				if((num & (1<<i))==1) {
					cnt++;
				}
			}
			if(cnt%3==1) {
				ans=ans|(1<<i);
			}
		}
		return ans;
	}

}
