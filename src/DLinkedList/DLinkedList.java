package DLinkedList;


public class DLinkedList {
	ListNode head;
	ListNode tail;
	
	DLinkedList(){
		head=null;
		tail=null;
	}
//	public ListNode convertArrayToDL(int[] nums) {
//		head=new ListNode(null,null,nums[0]);
//		ListNode mover=head;
//		for(int i=1;i<nums.length;i++) {
//			ListNode temp=new ListNode(mover,null,nums[i]);
//			mover.next=temp;
//			mover=temp;
//		}
//		tail=mover;
//		return head;
//	}
	
	public void printDL() {
		ListNode mover=head;
		while(mover!=null) {
			System.out.println(mover.value);
			mover=mover.next;
		}
	}
	
	/* delete head */
	public void deleteHead() {
		if(head==null || head.next==null) {
			head=null;
		}
		ListNode prev=head;
		head=head.next;
		head.prev=null;
		prev.next=null;
	}
	
	/* delete tail */
	public void deleteTail() {
		ListNode prev=tail;
		tail=tail.prev;
		tail.next=null;
		prev.prev=null;
	}
	
	/* add tail */
	public void addTail(ListNode node) {
		if(head ==null) {
			head=node;
			tail=node;
		}else {
			tail.next=node;
			node.prev=tail;
			tail=node;
		}
	}
	
	/* reverse  */
	public void reverse() {
		ListNode curr=head;
		ListNode last=null;
		while(curr!=null) {
			last=curr.prev;
			curr.prev=curr.next;
			curr.next=last;
			curr=curr.prev;
		}
		head=last.prev;	
	}
	
}
