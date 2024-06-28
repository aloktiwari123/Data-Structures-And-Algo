package recursion;

public class kthSymbol {
	
	public static int solve(int n,int k) {
		if(n==1 && k==1) {
			return 0;
		}
		
		int mid=(int) Math.pow(2,n-1)/2;
		
		if(k<=mid) {
			return solve(n-1,k);
		}
		else {
			return (solve(n-1,k-mid)==1 ? 0:1);
		}
	}
	
	public static void main(String args[]) {
		System.out.print(solve(2,2));
	}

}
