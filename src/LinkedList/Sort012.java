package LinkedList;

public class Sort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] head = {0,1,0,2,2,2,0,1};
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
		// TODO Auto-generated method stub
		ListNode zeroHead=new ListNode(-1);
		ListNode oneHead=new ListNode(-1);
		ListNode twoHead=new ListNode(-1);
		ListNode one=oneHead;
		ListNode two=twoHead;
		ListNode zero=zeroHead;
		
		while(root!=null) {
			if(root.val==0) {
				zero.next=root;
				zero=root;
			}else if(root.val==1) {
				one.next=root;
				one=root;
			}else {
				two.next=root;
				two=root;
			}
			root=root.next;
		}
		
		zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
		one.next=twoHead.next;
		two.next=null;
		root=zero.next;
	}

}
