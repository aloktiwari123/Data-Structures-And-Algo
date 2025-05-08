package LinkedList;

public class Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] head = {0,3,1,0,4,5,2,0};
		ListNode node=new ListNode(0,null);
		ListNode root=node;
		for(int i=1;i<head.length;i++) {
			ListNode nextNode=new ListNode(head[i],null);
			node.next=nextNode;
			node=nextNode;
		}		
	}

}
