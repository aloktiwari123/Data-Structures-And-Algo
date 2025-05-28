package DLinkedList;

public class ListNode {

	ListNode prev;
	ListNode next;
	String value;
	
	public ListNode(ListNode prev, ListNode next,String value) {
		this.prev = prev;
		this.next = next;
		this.value =value;
	}

	@Override
	public String toString() {
		return "ListNode [prev=" + prev + ", next=" + next +  ", value="+ value +"]";
	}	
	
	
}
