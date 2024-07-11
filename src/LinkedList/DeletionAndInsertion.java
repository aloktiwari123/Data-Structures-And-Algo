package LinkedList;

public class DeletionAndInsertion {

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
		//System.out.print(deleteNode(0,root));
		//System.out.print(deleteHead(root));
		System.out.print(deleteTail(root));
	}
	
	public static ListNode deleteHead(ListNode root) {
		root=root.next;
		return root;
	}
	
	public static ListNode deleteTail(ListNode root) {
		ListNode temp=root;
		
		// either its null or it has only one node which is going to be both head and tail
		if(root==null || root.next==null) {
			return null;
		}
		
		while(temp.next.next !=null) {
			temp=temp.next;
		}
		temp.next=null;
		return root;
	}
	
	public static ListNode deleteNode(int val,ListNode root) {
		ListNode temp=root;
		
		while(temp!=null) {
			if(temp.val==val) {
				root=root.next;
				break;
			}
			if(temp.next.val==val) {
				temp.next=temp.next.next;
				break;
			}
			temp=temp.next;
		}
		return root;
	}

}
