package LinkedList;

import java.util.Arrays;

public class SplitLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] head = {0};
		int k = 1;
		ListNode node=new ListNode(head[0],null);
		ListNode root=node;
		for(int i=1;i<head.length;i++) {
			ListNode nextNode=new ListNode(head[i],null);
			node.next=nextNode;
			node=nextNode;
		}
		System.out.println(root);
		System.out.println(length(root));
		System.out.print(Arrays.toString(splitList(root,k)));
	}
	
	public static ListNode[] splitList(ListNode root,int k) {
		int len=length(root);
		int sizeOfFirst=(len/k+1);
		int firstParts=len%k;
		int sizeOfRest=len/k;
		int currLen=0;
		ListNode head=root;
		ListNode[] list=new ListNode[k];
		ListNode node=new ListNode();
		ListNode rootNode = null;
		int c=0;
		while(firstParts>0) {
			currLen=0;
			while(currLen<sizeOfFirst) {
				if(currLen==0) { node=new ListNode(head.val,null); rootNode=node; }
				else {
					node.next=new ListNode(head.next.val,null);
					head=head.next;
					node=node.next;
				}
				currLen++;
			}
			list[c]=rootNode;
			head=head.next;
			firstParts--;
			c++;
		}
		node=new ListNode();
		rootNode=node;
		while(head!=null) {
			currLen=0;
			
			while(currLen<sizeOfRest) {
				if(currLen==0) { node=new ListNode(head.val,null);rootNode=node; }
				else {
					node.next=new ListNode(head.next.val,null);
					head=head.next;
					node=node.next;
				}
				currLen++;
			}
			list[c]=rootNode;
			head=head.next;
			c++;
		}
		
		return list;
	}
	
	public static int length(ListNode root) {
		int len=0;
		ListNode head=root;
		while(head !=null) {
			len++;
			head=head.next;
		}
		return len;
	}

}
