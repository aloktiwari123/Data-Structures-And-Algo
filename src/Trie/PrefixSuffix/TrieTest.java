package Trie.PrefixSuffix;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TrieForSuffixPrefix trie=new TrieForSuffixPrefix();
		String[] products = {"mobile","mouse","moneypot","monitor","mouse"};
		String searchWord = "mou";
		for(int i=0;i<products.length;i++) {
			trie.insert(products[i]);
		}
		System.out.println(trie.countWordsStartingWith(searchWord));
		System.out.println(trie.countWordsEqualTo("mouse"));
		trie.eraseWord("mouse");
		System.out.println(trie.countWordsEqualTo("mouse"));
	}
	
//	public static void LongestWordWithAllPrefix() {
//		Trie trie=new Trie();
//		String[] strs = {"n","ninja","ninj","ni","nin","ninga"};
//		for(int i=0;i<strs.length;i++) {
//			trie.insert(strs[i]);
//		}
//		String longestS="";
//		for(int i=0;i<strs.length;i++) {
//				
//			}
//		}
//		System.out.print(longestS);
//	}

}
