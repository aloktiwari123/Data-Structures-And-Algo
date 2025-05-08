package Trie.Bit.MaxXOR;

public class Trie {
	Node root;
	
	Trie(){
		root=new Node();
	}
	
	public void insert(int num) {
		Node node=root;
		
		for(int i=31;i>=0;i--) {
			// extract ith bit
			int bit=(num>>i)&1;
			if(!node.containsKey(bit)) {
				node.put(bit,new Node());
			}
			node=node.get(bit);
		}
	}
	
	public int getMax(int num) {
		Node node=root;
		int max=0;
		
		for(int i=31;i>=0;i--) {
			// extract ith bit
			int bit=(num>>i)&1;
			if(node.containsKey(1-bit)) {
				max=max|(1<<i);
				node=node.get(1-bit);
			}else {
				node=node.get(bit);
			}
		}
		return max;
	}

}
