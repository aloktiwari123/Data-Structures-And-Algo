package BitManipulation;

public class CheckSetBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/* left shift */
	public void solveLeft(int n,int i) {
		if((n&(1<<i))!=0) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
	}
	
	/* right shift */
	public void solveRight(int n,int i) {
		if(((n>>i)&1)!=0) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
	}

}
