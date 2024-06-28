package DynamicPrograming;

public class ScrambledString {
	
	public static void main(String args[]) {
		String s1="great";
		String s2="eatgr";
		if(s1.length()!=s2.length()) {
			System.out.print(false);
		}
		System.out.print(solve(s1,s2));
		
	}
	
	public static boolean solve(String s1,String s2) {
		int n=s1.length();
		if(s1.equals(s2)) {
			return true;
		}
		//with swap
		if(s1.length()<0) {
			return false;
		}
		boolean flag=false;
		
		for(int i=1;i<=n-1;i++) {
			// with swap
			//"great" compare "eatgr"
			boolean withSwap=solve(s1.substring(0,i),s2.substring(n-i))&&solve(s1.substring(i),s2.substring(0,n-i));
			// without swap
			//"great" compare "great"
			boolean withOutSwap=solve(s1.substring(0,i),s2.substring(0,i))&&solve(s1.substring(i),s2.substring(i));
			if(withSwap || withOutSwap) {
				flag=true;
				break;
			}
		}
		return flag;
	}

}
