package sliding_Window;
import java.util.*;
public class SubStringWithConcatedWords {

	public static void main(String args[]) {
		String[] words= {"fooo","barr","wing","ding","wing"};
		HashMap<String,Integer>wordsMap=new HashMap<>();
		int s2=0;
		for(String word:words) {
			s2+=1;
			wordsMap.put(word,wordsMap.getOrDefault(word,0)+1);
		}
		int s1=words[0].length();
		s2=s2*s1;
		String s="lingmindraboofooowingdingbarrwingmonkeypoundcake";
		if(s.length()>=s2) {
			System.out.print(solve(s,wordsMap,s1,s2));
		}
		else {
			System.out.print("");
		}
		
	}
	
	public static List<Integer>solve(String s,HashMap<String,Integer>wordsMap,int s1,int s2){
		int i=0;
		int j=0;
		char []arr=s.toCharArray();
		
		List<Integer>list=new ArrayList<>();
		StringBuilder str=new StringBuilder();
		while(j<arr.length) {
			str.append(arr[j]);
			if((j-i+1)<s2) {
				j++;
			}
			else if((j-i+1)==s2) {
				if(isValid(wordsMap,str.toString(),s1)) {
					list.add(i);
				}
				i++;
				str.deleteCharAt(0);
				j++;
			}
		}
		return list;
	}
	
	public static boolean isValid(HashMap<String,Integer>wordsMap,String s,int s1) {
		char[] ch=s.toCharArray();
		HashMap<String,Integer>words=new HashMap<>();
		int j=0;
		StringBuilder str=new  StringBuilder();
		while(j<ch.length) {
			str.append(ch[j]);
			if((j+1)%s1==0) {
				words.put(str.toString(),words.getOrDefault(str.toString(),0)+1);
				str.setLength(0);
			}
			j++;
		}
		return wordsMap.equals(words)?true:false;
	}
}
