package recursion;
import java.util.*;
public class LongestIncSubSequence {
	public static void main(String args[]) {
		int[] arr= {0,1,0,3,2,3};
		System.out.println(lengthOfLIS(arr));
		System.out.println(lengthOfLISRec(0,-1,arr,arr.length));
	}
	
	public static int lengthOfLISRec(int index,int prevIdx,int[] nums,int n) {
		if(index == n) {
			return 0;
		}
		int len = lengthOfLISRec(index+1,prevIdx,nums,n);
		if (prevIdx == -1 || nums[index] > nums[prevIdx]) {
        len = Math.max(len, 1 + lengthOfLISRec(index + 1, index, nums, n));
		}
//		if (prevIdx == -1 || nums[index] > nums[prevIdx]) {
//            len = Math.max(lengthOfLISRec(index+1,prevIdx,nums,n), 1 + lengthOfLISRec(index + 1, index, nums, n));
//        }
//		else {
//			len = lengthOfLISRec(index+1,prevIdx,nums,n);
//		}
		return len;
	}
	
	public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().orElse(0);
        return maxLength;
    }

}
