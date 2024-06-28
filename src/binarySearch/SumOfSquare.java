package binarySearch;

public class SumOfSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solve(2));
	}
	
	public static boolean solve(int c) {
		long i=0;
		long j=(long) Math.sqrt(c);
		long sum=0;
		while(i<=j) {
			sum=(i*i)+(j*j);
			if(sum==c) {
				return true;
			}
			else if(sum>c) {
				j--;
			}
			else {
				i++;
			}
		}
		return false;
	}

}
