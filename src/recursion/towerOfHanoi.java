package recursion;

public class towerOfHanoi {
	public static void main(String args[]) {
		int s=1;
		int h=2;
		int d=3;
		int n=3;
		solve(s,d,h,n);
	}
	
	public static void solve(int s,int d,int h,int n) {
		if(n==1) {
			System.out.println(s+"-->"+d);
			return;
		}
		solve(s,h,d,n-1);
		System.out.println(s+"-->"+d);
		solve(h,d,s,n-1);
		return;
	}

}
