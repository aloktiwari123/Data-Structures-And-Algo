package Trie.PrefixSuffix;

public class TrieForSuffixPrefix {
		public static Node root;
		
		public TrieForSuffixPrefix() { 
			root=new Node();
		}
		
		// insert word into a trie
		public void insert(String word) {
			Node node = root;
			
			for(int i=0;i<word.length();i++) {
				if(!node.containsKey(word.charAt(i))) {
					node.put(word.charAt(i),new Node());
				}
				node=node.get(word.charAt(i));
				node.cp+=1;
			}
			
			node.ew+=1;
		}
		
		// count words equal to given word
		public int countWordsEqualTo(String word) {
			Node node=root;
			
			for(int i=0;i<word.length();i++) {
				if(node.containsKey(word.charAt(i))) {
					node=node.get(word.charAt(i));
				}
				else {
					return 0;
				}
			}
			return node.ew;
		}
		
		// count prefix
		public int countWordsStartingWith(String prefix) {
			Node node=root;
			
			for(int i=0;i<prefix.length();i++) {
				if(!node.containsKey(prefix.charAt(i))) {
					return 0;
				}
				node=node.get(prefix.charAt(i));
			}
			return node.cp;
		}
		
		
		// erase word
		public void eraseWord(String word) {
			Node node=root;
			
			for(int i=0;i<word.length();i++) {
				if(node.containsKey(word.charAt(i))) {
					node=node.get(word.charAt(i));
					node.cp-=1;
				}
				else {
					return;
				}
			}
			node.ew-=1;
		}
	

}
