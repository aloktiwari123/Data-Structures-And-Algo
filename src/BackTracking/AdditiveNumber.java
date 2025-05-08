package BackTracking;

public class AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="112358";
		System.out.println(isAdditive(string));
	}
	
	public static boolean isAdditive(String num) {
		 if (num == null || num.length() < 3) return false;   
		    return solve( null, null,num, 0,0);
	}
	
	public static boolean solve(Long num1,Long num2,String s,int idx,int numbers) {
		if(idx==s.length()) return numbers>=3;
		
		long currNum=0;
		for(int i=idx;i<s.length();i++) {
			currNum=currNum*10+(s.charAt(i)-'0');
			if(num1==null || num2==null || currNum==(num1+num2)) {
				if(solve(num2,currNum,s,i+1,numbers+1)) return true;
			}
			if (s.charAt(i) == '0') break; 
		}
		return false;
	}

}
