package BackTracking;
import java.util.*;

public class WordBreak {

	public static void main(String args[]) {
		 String s = "catsanddog";
		 String [] str={"cats","dog","sand","and","cat"};
		 HashSet<String> wordDict =new HashSet<String>();
		 for(String t:str) {
			 wordDict.add(t);
		 }
		;
		System.out.print(solve(s,0,wordDict));
	}
	
	public static List<String> solve(String s,int idx,HashSet<String> wordDict) {
		List<String> validSubs=new ArrayList<>();
		if(idx==s.length()) {
			validSubs.add("");
		}
		
		for(int i=idx;i<s.length();i++) {
			String suffix=s.substring(idx,i+1);
			if(wordDict.contains(suffix)) { 
				List<String> prefixes =solve(s,i+1,wordDict);
				
				for(String prefix:prefixes) {
					validSubs.add(suffix+(prefix.equals("") ? "" : " ")+prefix);
				}
	
			}
		}
		
		return validSubs;
	}

}
