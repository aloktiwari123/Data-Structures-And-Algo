package DynamicPrograming;

import java.util.*;

public class CoinChangeII {

	static List<List<Integer>>list=new ArrayList<>();
	public static void main(String args[]) {
		int sum=5;
		int[] arr= {1,2,3};
		solve(arr,arr.length,sum,new ArrayList<>());
		System.out.println(list);
		System.out.println(solveMin(arr,arr.length,sum,new ArrayList<>()));
	}
	
	// all possible combinations to achieve given sum;
	public static void solve(int coins[],int n,int sum,List<Integer>op){
		if(n==0) {
			if(sum==0) {
				list.add(new ArrayList<>(op));	
			}
			return;
		}
		
		if(coins[n-1]<=sum) {
			solve(coins,n-1,sum,op);
			List<Integer>op2=new ArrayList<>(op);
			op2.add(coins[n-1]);
			solve(coins,n,sum-coins[n-1],op2);
		}
		else {
			solve(coins,n-1,sum,op);
		}
	}
	
	// min selection to achieve the required sum
	public static int solveMin(int coins[],int n,int sum,List<Integer>op){
		if(n==0) {
			return sum==0?op.size():Integer.MAX_VALUE;
		}
		
		if(coins[n-1]<=sum) {
			int n1=solveMin(coins,n-1,sum,op);
			List<Integer>op2=new ArrayList<>(op);
			op2.add(coins[n-1]);
			int n2=solveMin(coins,n,sum-coins[n-1],op2);
			return Math.min(n1, n2);
		}
		else {
			return solveMin(coins,n-1,sum,op);
		}
	}
	
	public static int coinChange(int[] coins, int amount) {

        int  dp[][]=new int[coins.length+1][amount+1];
        
        for(int i=0;i<=amount;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for(int j=1;j<=coins.length;j++){
            dp[j][0]=0;
        }
        
        for(int i=1,j=1;j<=amount;j++){
            if(j%coins[0]==0){
                dp[i][j]=j/coins[0];
            }
            else{
                dp[i][j]=Integer.MAX_VALUE-1;
            }
        }
        
        for(int i=2;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        if(dp[coins.length][amount] != Integer.MAX_VALUE - 1) {
	        return dp[coins.length][amount];
	    }
	    
	    return -1;
    }
}
