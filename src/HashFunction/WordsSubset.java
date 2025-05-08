package HashFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words1 = {"amazon","apple","facebook","google","leetcode"};
		String[] words2 = {"e","o"};
		System.out.print(solve(words1,words2));
	}
	
	public static List<String> solve(String[] words1, String[] words2){
		HashMap<String,HashMap<Character,Integer>>map=new HashMap<>();
		for(String word:words1) {
			map.put(word,getFreq(word));
		}
		
		List<String>ans=new ArrayList<>();
		for(String word:words2) {
			HashMap<Character,Integer>freq=getFreq(word);
			for(Map.Entry<String,HashMap<Character,Integer>> entry:map.entrySet()) {
				boolean next=false;
				for(char ch:word.toCharArray()) {
					if(!entry.getValue().containsKey(ch) || entry.getValue().get(ch)<freq.get(ch)) {
						next=true;
						if(ans.contains(entry.getKey())) ans.remove(entry.getKey());
						break;
					}
				}
				if(next==false && !ans.contains(entry.getKey())) ans.add(entry.getKey());
			}
		}
		return ans;
		
	}
	
	public static HashMap<Character,Integer> getFreq(String word){
		HashMap<Character,Integer>freq=new HashMap<>();
		for(char ch:word.toCharArray()) {
			freq.put(ch,freq.getOrDefault(ch,0)+1);
		}
		return freq;
	}

}
