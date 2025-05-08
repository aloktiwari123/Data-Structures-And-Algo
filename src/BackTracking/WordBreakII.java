package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordBreakII {

	static List<String>ans=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		List<String> wordDict=new ArrayList<String>() {{
			add("cat");
			add("cats");
			add("and");
			add("sand");
			add("dog");
		}};
		//wordDict = ["cat","cats","and","sand","dog"]
		solve(s,new ArrayList<>(),wordDict);
		System.out.print(ans);
	}
	
	public static void solve(String s,List<String>list,List<String> wordDict) {
		if(s.equals("")) {
			String result = list.stream()
                    .collect(Collectors.joining(" "));
			ans.add(result);
			return;
		}
		
		for(int i=0;i<s.length();i++) {
			String s1=s.substring(0,i+1);
			String s2=s.substring(i+1,s.length());
			if(wordDict.contains(s1)) {
				list.add(s1);
				solve(s2,list,wordDict);
				list.remove(list.size()-1);
			}
		}
	}

}
