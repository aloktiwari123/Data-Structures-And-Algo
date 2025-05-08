package Trie.LongestWordWithAllPrefix;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(LongestWordWithAllPrefix());
	}
	
	
	public static String LongestWordWithAllPrefix() {
		Trie trie=new Trie();
		String[] strs = {"n","ninja","ninj","ni","nin","ninga"};
		for(int i=0;i<strs.length;i++) {
			trie.insert(strs[i]);
		}
		String longest ="";
		for(String s:strs) {
			if(trie.checkIfPrefixExists(s)) {
				if(s.length()>longest.length()) {
					longest=s;
				}
			}
		}
		
		return longest==""?"None":longest;
	}
	
}
