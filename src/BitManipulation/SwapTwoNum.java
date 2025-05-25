package BitManipulation;

public class SwapTwoNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(1, 2);
	}
	
	/*XOR*/
	public static void solve(int a,int b) {
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a);
		System.out.println(b);
	}

}
