package recursion;

public class resolveInKSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcyy";
		int t=2;
		System.out.println(solve(s, t));
		
	}
	
	public static String solve(String s,int t) {
		if(t==0) return s;
		StringBuilder stringBuilder=new StringBuilder();
		for(char ch:s.toCharArray()) {
			if(ch==122) {
				stringBuilder.append('a').append('b');
			}
			else {
				stringBuilder.append((char)(ch+1));
			}
		}
		return solve(stringBuilder.toString(), t-1);
	}

}
