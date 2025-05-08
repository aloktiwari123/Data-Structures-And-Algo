package Trie.MagicDic;

import Trie.BasicTrie.Node;

	public class Trie {
	Node root;
	
	Trie(){
		root=new Node();
	}
	
	public void insert(String word) {
		Node node=root;
		for(char ch:word.toCharArray()) {
			if(!node.containsKey(ch)) {
				node.put(ch,new Node());
			}
			node=node.get(ch);
		}
		node.setEnd();
	}
	
	public boolean searchWithChange(String word) {
		Node node=root;
		int count=0;
		for(char ch:word.toCharArray()) {
			if(!node.containsKey(ch)) {
				count++;
				node.put(ch,new Node());
			}
			node=node.get(ch);
		}
		return node.flag==true && count==1;
	}
	
}
