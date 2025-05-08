package Trie.PrefixSuffix;

class Node {
	Node links[]=new Node[26];
	int ew=0;
	int cp=0;
	
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
	
}

