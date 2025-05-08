package Trie.LongestWordWithAllPrefix;

public class Trie {
	
	Node root;
	
	Trie(){
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
	
	public boolean checkIfPrefixExists(String word) {
		Node node = root;
		boolean flag=true;
		for(int i=0;i<word.length() && flag;i++) {
			if(node.containsKey(word.charAt(i))) {
				node=node.get(word.charAt(i));
				flag=flag & node.flag;
			}else {
				return false;
			}
		}
		return flag;
	}


}
