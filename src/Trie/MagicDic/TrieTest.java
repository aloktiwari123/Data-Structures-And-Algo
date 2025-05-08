package Trie.MagicDic;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		String[] strs={"hello", "leetcode"};
		for(String str:strs) {
			trie.insert(str);
		}
		String[] inputs={"hello","hhllo","hell","leetcoded"};
		for(String str:inputs) {
			System.out.println(trie.searchWithChange(str));
		}

	}
}
