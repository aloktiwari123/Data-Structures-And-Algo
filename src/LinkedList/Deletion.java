package LinkedList;

public class Deletion {

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
		System.out.print(deleteNodeAtK(3,root));
	}
	
	// delete head
	public static ListNode deleteHead(ListNode root) {
		root=root.next;
		return root;
	}
	
	// delete tail
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
	
	// delete on count
	public static ListNode deleteNodeAtK(int k,ListNode root) {
		if(root==null) return null;
		
		if(k==1) return root.next;
		
		ListNode temp=root;
		ListNode prev=null;
		int count=0;
		while(temp !=null) {
			count++;
			if(count==k) {
				prev.next=temp.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		
		return root;
	}
	
	// delete on val
	public static ListNode deleteNode(int val,ListNode root) {
		if(root==null) return null;
		
		if(root.val==val) return root.next;
		
		ListNode temp=root;
		ListNode prev=null;
		while(temp!=null) {
			if(temp.val==val) {
				prev.next=temp.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return root;
	}

}
