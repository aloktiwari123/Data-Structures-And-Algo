package Trie.DistinctSubstring;

import Trie.BasicTrie.Node;

public class Trie {
	Node root;
	int countSubs=0;
	
	public Trie(){
		root=new Node();
	}
	
	public void insert(String word) {
		Node node=root;
		for(char ch:word.toCharArray()) {
			if(!node.containsKey(ch)) {
				node.put(ch,new Node());
				countSubs++;
			}
			node=node.get(ch);
		}
	}
	

}
