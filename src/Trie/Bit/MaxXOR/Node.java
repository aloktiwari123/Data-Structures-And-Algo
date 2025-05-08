package Trie.Bit.MaxXOR;

public class Node {
	Node[] links;
	
	Node(){
		links=new Node[2];
	}
	
	public boolean containsKey(int bit) {
		return links[bit]!=null;
	}
	
	public Node get(int bit) {
		return links[bit];
	}
	
	public void put(int bit,Node node) {
		links[bit]=node;
	}

}
