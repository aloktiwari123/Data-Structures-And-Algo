package DLinkedList;

public class LFURunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
		 LFUCache obj = new LFUCache(2);
		 obj.put(1,1);
		 obj.put(2,2);
		 int param_1 = obj.get(1);
		 obj.put(3,3);
		 int param_2 = obj.get(2);
		 int param_3 = obj.get(3);
		 

	}

}
