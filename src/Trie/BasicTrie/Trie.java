package Trie.BasicTrie;

public class Trie {

	public static Node root;
	
	public Trie() { 
		root=new Node();
	}
	
	public void insert(String word) {
		Node node = root;
		
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i),new Node());
			}
			node=node.get(word.charAt(i));
		}
		
		node.setEnd();
	}
	
	public boolean containsWord(String word) {
		Node node=root;
		
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				return false;
			}
			node=node.get(word.charAt(i));
		}
		return node.flag==true?true:false;
	}
	
	public boolean startsWith(String prefix) {
		Node node=root;
		
		for(int i=0;i<prefix.length();i++) {
			if(!node.containsKey(prefix.charAt(i))) {
				return false;
			}
			node=node.get(prefix.charAt(i));
		}
		return true;
	}
}
