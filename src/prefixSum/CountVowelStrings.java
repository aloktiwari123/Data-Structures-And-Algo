package prefixSum;
import java.util.Arrays;
import java.util.HashSet;

public class CountVowelStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] words = {"a","e","i"};
		int[][] queries = {{0,2},{0,1},{2,2}};
		System.out.print(Arrays.toString(solve(words,queries)));
	}
	
	public static int[] solve(String[] words,int[][] queries) {
		int[] ans=new int[queries.length];
		int[] prefixSum=new int[words.length];
		
		HashSet<Character>set=new HashSet<Character>(){{
			add('a');
			add('e');
			add('i');
			add('o');
			add('u');
			}};
			
		int c=0;
		for(int i=0;i<words.length;i++) {
			String word=words[i];
			char lc=word.charAt(0);
			char rc=word.charAt(word.length()-1);
			if(set.contains(lc) && set.contains(rc)) {
				c+=1;
			}
			prefixSum[i]=c;
		}
		
		for(int i=0;i<queries.length;i++) {
			int lIdx=queries[i][0];
			int rIdx=queries[i][1];
			int temp=prefixSum[rIdx]-((lIdx-1)==-1?0:prefixSum[lIdx-1]);
			ans[i]=temp;					
		}
		
		return ans;
	}

}
