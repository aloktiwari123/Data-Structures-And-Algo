package sliding_Window;

import java.util.ArrayList;
import java.util.List;

public class countSubArrayWithCond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = {1,2,1,4,1};
		 System.out.println(solve(nums));
	}
	
	public static int solve(int[] nums) {
		int i=0;
		int j=0;
		int count =0;
		List<Integer>st=new ArrayList<>();
		while(j<nums.length) {
			st.add(nums[j]);
			if((j-i+1)<3) {
				j++;
			}else if((j-i+1)==3) {
				if(st.get(1)==(st.get(0)+st.get(2))*2) {
					count+=1;
				}
				st.remove(0);
				i++;
				j++;
			}
		}
		return count;
		
	}

}
