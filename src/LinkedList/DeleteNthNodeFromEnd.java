package LinkedList;

public class DeleteNthNodeFromEnd {

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
		solve(root, 2);
	}

	private static ListNode solve(ListNode root,int k) {
		// TODO Auto-generated method stub

		ListNode fast=root;
		ListNode slow=root;
		while(k>0) {
			fast=fast.next;
			k--;
		}
		if(fast==null) return root.next;
		while(fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		slow.next=slow.next.next;
		return root;
	}

}
