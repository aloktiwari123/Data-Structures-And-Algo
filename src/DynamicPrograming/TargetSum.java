package DynamicPrograming;

import java.util.HashMap;

//Problem Similar to countSubset With given diff
public class TargetSum {
	public static void main(String args[]) {
		int arr[] = {1,1,2,3};
		int target=1;
		int sum=0;
        for(int n:arr){
            sum+=n;
        }
        if(((sum - target) % 2 == 1) || (target > sum))
            System.out.print(0);
        sum=(sum-target)/2;
        HashMap<String,Integer>map=new HashMap<>();
		System.out.println(solveDp(arr.length,arr,sum));	
		System.out.print(solve(arr.length,arr,sum,map));	
	}
	
	// DP
	public static int solveDp(int n,int[] arr,int sum) {
		int[][] t=new int[n+1][sum+1];
		for(int i=0;i<sum+1;i++) {
			t[0][i]=0;
		}
		for(int i=0;i<n+1;i++) {
			t[i][0]=1;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
				}
				else {
					t[i][j]=t[i-1][j];
				}
			} 
		}
		return t[n][sum];
	}
	
	// Recursive
	public static int solve(int n,int[] arr,int sum,HashMap<String,Integer>map) {
		if(n==0) {
			return sum==0?1:0;
		}
		
		if(map.containsKey(n+"|,|"+sum)) {
			return map.get(n+"|,|"+sum);
		}

		if(arr[n-1]<=sum) {
			map.put(n+"|,|"+sum, solve(n-1,arr,sum,map)+solve(n-1,arr,sum-arr[n-1],map));
		}
		else {
			map.put(n+"|,|"+sum,solve(n-1,arr,sum,map));
		}
		return map.get(n+"|,|"+sum);
	}
}
