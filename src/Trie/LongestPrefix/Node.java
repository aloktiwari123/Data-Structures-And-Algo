package Trie.LongestPrefix;

public class Node {
	Node[] links=new Node[26];
	public boolean flag=false;
	
	public Node() {}
	
	public boolean containsKey(char ch) {
		return links[ch-'a']!=null;
	}
	
	public void put(char ch,Node node) {
		links[ch-'a']=node;
	}
	
	public char getCommon() {
		int c=0;
		char ch='\u0000';
		for(int i=0;i<links.length;i++) {
			Node link=links[i];
			if(link!=null) {
				c++;
				if(c>1) return '\u0000';
				ch=(char)(i+'a');
			}
		}
		return ch;
		
	}
	
	public Node get(char ch) {
		return links[ch-'a'];
	}

	public void setEnd() {
		flag=true;
	}
}
