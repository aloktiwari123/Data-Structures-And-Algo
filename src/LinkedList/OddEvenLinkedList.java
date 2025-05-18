package LinkedList;

import java.util.ArrayList;
import java.util.List;
public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] head = {0,3,1,0,4,5,2,0,7};
		ListNode node=new ListNode(0,null);
		ListNode root=node;
		for(int i=1;i<head.length;i++) {
			ListNode nextNode=new ListNode(head[i],null);
			node.next=nextNode;
			node=nextNode;
		}
		
		solve(root);
		System.out.println(root);
	}
	
	public static void solve(ListNode root) {
		ListNode odd=root;
		ListNode even=root.next;
		ListNode evenHead=root.next;
		while(even!=null && even.next!=null) {
			odd.next=odd.next.next;
			even.next=even.next.next;
			odd=odd.next;
			even=even.next;
		}
		odd.next=evenHead;
	}
	
}
