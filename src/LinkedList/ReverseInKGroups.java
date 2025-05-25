package LinkedList;

public class ReverseInKGroups {

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
		reverseInKGroups(root,3);
	}
	
	public static void reverseInKGroups(ListNode head,int k) {
		ListNode temp=head;
		ListNode prev=null;
		
		while(temp!=null) {
			
			ListNode kthNode=getKthNode(temp,k);
			if(kthNode==null) {
				if(prev!=null) prev.next=temp;
				break;
			}
			
			ListNode nextNode=kthNode.next;
			kthNode.next=null;
			reverse(temp);
			if(temp==head) {
				head=kthNode;
			}else {
				prev.next=kthNode;
			}
			prev=temp;
			temp=nextNode;	
		}
		
		System.out.print(head);
	}

	private static void reverse(ListNode temp) {
		// TODO Auto-generated method stub
		ListNode curr=temp;
		ListNode prev=null;
		while(curr!=null) {
			ListNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		temp=curr;
	}

	private static ListNode getKthNode(ListNode temp,int k) {
		// TODO Auto-generated method stub
		k=k-1;
		while(temp!=null && k>0) {
			k--;
			temp=temp.next;
		}
		return temp;
	}

}
