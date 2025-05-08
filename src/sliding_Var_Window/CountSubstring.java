package sliding_Var_Window;

import java.util.HashMap;
import java.util.HashSet;

import stack.solveExpression;

public class CountSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String word = "aeiou";
		 int k = 0;
		 System.out.println(solve(word,k)-solve(word, k-1));
	}
	
	public static long solve(String word,int k) {
		HashMap<Character,Integer>vowelMap=new HashMap<>();
		HashSet<Character>set=new HashSet<Character>() {{
			add('a');
			add('e');
			add('i');
			add('o');
			add('u');
		}};
		int count=0;
		int i=0;
		int j=0;
		char[] arr=word.toCharArray();
		long ans=0;
		while(j<arr.length) {
			if(set.contains(arr[j])) {
				vowelMap.put(arr[j],vowelMap.getOrDefault(arr,0)+1);
			}else {
				count++;
			}
			
			if(count<k) {
				j++;
			}else if(count==k) {
				if(vowelMap.size()==set.size()) ans+=(j-i+1);
				j++;
			}else if(count>k){
				while(count>k) {
					if(set.contains(arr[i])) {
						vowelMap.put(arr[i],vowelMap.get(arr[i])-1);
						if(vowelMap.get(arr[i])==0) {
							vowelMap.remove(arr[i]);
						}
					}else {
						count--;
					}
					i++;
				}
				if(vowelMap.size()==set.size()) ans+=(j-i+1);
				j++;
			}
		}
		
		return ans;
	}

}
