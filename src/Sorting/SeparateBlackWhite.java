package Sorting;

public class SeparateBlackWhite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "100";
		System.out.print(solve(s));

	}
	
	public static int solve(String s) {
		int count=0;
		int ans=0;
		char ch[]=s.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			if(ch[i]=='0') ++count;
			else {
				 ans+=count;
			}
		}
		return ans;
	}

}
