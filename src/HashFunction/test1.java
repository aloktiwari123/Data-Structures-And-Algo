package HashFunction;

import java.util.HashMap;
import java.util.HashSet;

import stack.solveExpression;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "successes";
		System.out.println(solveExpression(s));
		
	}
	
	public static int solveExpression(String s) {
		int maxVowel=0;
		int maxConst=0;
		HashMap<Character,Integer>vowelsHashMap=new HashMap<>();
		HashMap<Character,Integer>consHashMap=new HashMap<>();
		HashSet<Character>set=new HashSet<Character>() {{
			add('a');
			add('e');
			add('i');
			add('o');
			add('u');
		}};
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(set.contains(ch)) {
				vowelsHashMap.put(ch,vowelsHashMap.getOrDefault(ch,0)+1);
				if(maxVowel<vowelsHashMap.get(ch)) {
					maxVowel=vowelsHashMap.get(ch);
				}
			}else {
				consHashMap.put(ch,consHashMap.getOrDefault(ch,0)+1);
				if(maxConst<consHashMap.get(ch)) {
					maxConst=consHashMap.get(ch);
				}
			}
		}
		return maxConst+maxVowel;
	}

}
