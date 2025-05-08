package Trie.LongestWordWithAllPrefix;

public class Node {
	
	Node[] links=new Node[26];
	boolean flag=false;
	
	Node(){};
	
	public boolean containsKey(char ch) {
		return links[ch-'a']!=null?true:false;
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
