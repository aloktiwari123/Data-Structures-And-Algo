package HashFunction;
import java.util.HashSet;

public class UniqueLengthPalin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabca";
		System.out.print(solve(s));
	}
	
	public static int solve(String s) {
		HashSet<Character>set=new HashSet<Character>();
		int count=0;
		for(char ch:s.toCharArray()) {
			set.add(ch);
		}
		
		for(char ch:set) {
			int i=-1;
			int j=0;
			
			for(int k=0;k<s.length();k++) {
				if(ch==s.charAt(k)) {
					if(i==-1) i=k;
					j=k;
				}
			}
			
			// unique between chars
			HashSet<Character>range=new HashSet<Character>(); 
			for(int k=i+1;k<j;k++) {
				range.add(s.charAt(k));
			}
			count+=range.size();
		}
		
		return count;
	}
	
}
