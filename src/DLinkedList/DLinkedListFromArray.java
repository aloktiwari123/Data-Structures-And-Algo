package DLinkedList;

public class DLinkedListFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3,4};
		DLinkedList dLinkedList=new DLinkedList();
		dLinkedList.convertArrayToDL(nums);
		//dLinkedList.printDL();
		//dLinkedList.deleteHead();
		//dLinkedList.printDL();
		//dLinkedList.deleteTail();
		dLinkedList.reverse();
		dLinkedList.printDL();
		
		
	}

}
