package Trie.DistinctSubstring;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		String s="abab";
		for(int i=0;i<s.length();i++) {
			System.out.println(s.substring(i));
			trie.insert(s.substring(i));
		}
		System.out.print(trie.countSubs+1);

	}

}
