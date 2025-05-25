package BitManipulation;

public class MinFlipToConvert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(10,7));
	}
	
	public static int solve(int n1,int n2) {
		int n=n1^n2;
		int cnt=0;
		while(n!=0) {
			// change rightmost set bit
			n=n&n-1;
			cnt++;
		}
		return cnt;
	}

}
