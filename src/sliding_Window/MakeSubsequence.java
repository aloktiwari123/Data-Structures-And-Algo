package sliding_Window;

public class MakeSubsequence {

	public static void main(String args[]) {
//		String s = "coaching";
//		String t = "coding";
		String s = "a";
		String t = "z";
		
		//System.out.print(solve(s,t));
		System.out.print(longestPalindrome("abccccdd"));
	}
	
	public static int solve(String s,String t) {
		int i=0;
		int j=0;
		
		while(i<s.length()) {
			if(j<t.length() && s.charAt(i)==t.charAt(j)) {
				j++;
			}
			i++;
		}
		return j>t.length()-1?0:t.length()-j;
	}
	
	 public static int longestPalindrome(String s) {
	        int[] count = new int[128];
	        for (char c: s.toCharArray())
	            count[c]++;

	        int ans = 0;
	        for (int v: count) {
	            ans += v / 2 * 2;
	            if (ans % 2 == 0 && v % 2 == 1)
	                ans++;
	        }
	        return ans;
	    }
}
