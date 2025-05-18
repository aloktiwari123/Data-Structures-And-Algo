package LinkedList;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l1 = {9,9,9,9};
		ListNode node=new ListNode(l1[0],null);
		ListNode root=node;
		for(int i=1;i<l1.length;i++) {
			ListNode nextNode=new ListNode(l1[i],null);
			node.next=nextNode;
			node=nextNode;
		}
		
		
		solve(root, 0);
		System.out.println(root);
		
	}

	private static void solve(ListNode root, int i) {
		// TODO Auto-generated method stub
		ListNode fast=root.next.next;
		ListNode slow=root;
		
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;
	}

}
