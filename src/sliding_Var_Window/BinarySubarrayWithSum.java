package sliding_Var_Window;
import java.util.*;
public class BinarySubarrayWithSum {
	
	public  static void main(String args[]) {
		int[] arr= {1,0,1,0,1};
		System.out.print(atMostSubarrayWithSum(arr,2));
		//System.out.print(numSubarraysWithSum(arr,2));
	}
	
	 public static int numSubarraysWithSum(int[] nums, int goal) {
		 int i=0,j=0;
		 int sum=0;
		 int count=0;
		 while(j<nums.length) {
			 sum=sum+nums[j];
			 if(sum<goal) {
				j++;
			 }
			 else if(sum==goal) {
				 count++;
				 j++;
			 }
			 else if(sum>goal) {
				 while(sum>goal || nums[i]==0) {
					 sum=sum-nums[i];
					 i++;
				 }
				 j++;
			 }
		 }
		 return count;   
    }
	
	public static int atMostSubarrayWithSum(int[] nums,int goal) {
		 int i=0,j=0;
		 int sum=0;
		 int count=0;
		 while(j<nums.length) {
			 sum=sum+nums[j];
			 if(sum<=goal) {
				 count+=(j-i+1);
				 j++;
			 }
			 else if(sum>goal) {
				 while(sum>goal) {
					 sum=sum-nums[i];
					 i++;
				 }
				 count+=(j-i+1);
				 j++;
			 }
		 }
		 return count; 
		
	}

}
