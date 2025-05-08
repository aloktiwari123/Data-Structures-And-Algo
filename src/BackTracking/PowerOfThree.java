package BackTracking;

public class PowerOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		System.out.println(solve(0,n));
	}
	
	public static boolean solve(int pow,int num) {
		if(num==0) {
			return true;
		}
		
		if(Math.pow(3,pow)>num) return false;

		boolean takeIt=solve(pow+1, num-(int)Math.pow(3,pow));
		boolean nottakeIt=solve(pow+1,num);
		
		return takeIt||nottakeIt;
	}

}
