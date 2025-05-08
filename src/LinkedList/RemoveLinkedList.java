package LinkedList;
import java.util.Stack;

public class RemoveLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] head = {5,2,13,3,8};
		ListNode node=new ListNode(head[0],null);
		ListNode root=node;
		for(int i=1;i<head.length;i++) {
			ListNode nextNode=new ListNode(head[i],null);
			node.next=nextNode;
			node=nextNode;
		}
		System.out.println(root);
		solve(root);
	}
	
	public static ListNode solve(ListNode head) {
		Stack<Integer>st=new Stack<>();
		ListNode root=head;
		while(root != null) {
			if(st.isEmpty()) {
				st.add(root.val);
			}else {
				while(!st.isEmpty() && st.peek()<root.val) {
					st.pop();
				}
				st.add(root.val);
			}
			root=root.next;
		}
		
		// reverse stack
		Stack<Integer>rst=new Stack<>();
		while(!st.isEmpty()) {
			rst.add(st.pop());
		}
		
		ListNode node=new ListNode(rst.peek());
		ListNode temp=node;
		rst.pop();
		while(!rst.isEmpty()) {
			int val=rst.peek();
			ListNode nextNode=new ListNode(val,null);
			node.next=nextNode;
			node=nextNode;
			rst.pop();
		}
		System.out.println(temp);
		return null;
	}

}
