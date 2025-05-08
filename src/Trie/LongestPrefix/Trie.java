package Trie.LongestPrefix;

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
	}
	
	public String commonPrefix() {
		Node node=root;
		String s="";
		while(node.getCommon()!='\u0000') {
			s+=node.getCommon()!='\u0000'?node.getCommon():"";
			node=node.get(node.getCommon());
		}
		return s;
	}
	

}
