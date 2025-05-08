package recursion;

public class powerOfN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(pow(3, 3));

	}
	
	public static long pow(int x,int n) {
		if(n==0) return 1;
		
		if(n%2==0) {
			long ans=pow(x, n/2);
			return ans*ans;
		}else {
			return x*pow(x, n-1);
		}
	}

}
