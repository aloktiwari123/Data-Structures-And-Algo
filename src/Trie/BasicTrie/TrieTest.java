package Trie.BasicTrie;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		trie.insert("apple");
		System.out.print(trie.containsWord("apple"));
		System.out.print(trie.startsWith("app"));	
	}
	


}
