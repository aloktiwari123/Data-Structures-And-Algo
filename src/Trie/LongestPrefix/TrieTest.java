package Trie.LongestPrefix;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		String[] strs = {"dog","racecar","car"};
		for(String str:strs) {
			trie.insert(str);
		}
		System.out.print(trie.commonPrefix());

	}

}
