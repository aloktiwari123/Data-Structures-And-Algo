package Trie.BasicTrie;

public class Node {
	Node links[]=new Node[26];
	public boolean flag=false;
	
	public Node() {}
	
	public boolean containsKey(char ch) {
		return links[ch-'a']!=null;
	}
	
	public void put(char ch,Node node) {
		links[ch-'a']=node;
	}
	
	public Node get(char ch) {
		return links[ch-'a'];
	}

	public void setEnd() {
		flag=true;
	}
	
	
}


