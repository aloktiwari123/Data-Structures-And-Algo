package LinkedList;

public class AddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l1 = {9,9,9,9,9,9,9};
		int[] l2 = {9,9,9,9};
		ListNode node1=new ListNode(l1[0],null);
		ListNode root1=node1;
		for(int i=1;i<l1.length;i++) {
			ListNode nextNode=new ListNode(l1[i],null);
			node1.next=nextNode;
			node1=nextNode;
		}
		ListNode node2=new ListNode(l2[0],null);
		ListNode root2=node2;
		for(int i=1;i<l2.length;i++) {
			ListNode nextNode=new ListNode(l2[i],null);
			node2.next=nextNode;
			node2=nextNode;
		}
		System.out.println(root1);
		System.out.println(root2);
		System.out.println(solve(root1,root2));
	}
	
	public static ListNode solve(ListNode root1, ListNode root2) {
		// TODO Auto-generated method stub
		ListNode num1=reverse(root1);
		ListNode num2=reverse(root2);
		ListNode ans=add(num1,num2,0);
		return ans;
	}
	
	public static ListNode add(ListNode root1, ListNode root2,int carry) {
		
		if(root1 == null && root2 == null) {
			return carry != 0 ? new ListNode(carry,null):null; 
		}
		
		ListNode node=new ListNode(0,null);
		int sum=0;
		if(root1 == null) {
			sum=root2.val+carry;
			node.val=(root2.val+carry) % 10;
			carry=sum / 10;
			node.next=add(root1,root2.next,carry);
			
		}
		else if(root2 == null) {
			sum=root1.val+carry;
			node.val=(root1.val+carry) % 10;
			carry=sum / 10;
			node.next=add(root1.next,root2,carry);
			
		}else {
			sum=root1.val+root2.val+carry;
			node.val=(root1.val+root2.val+carry) %10;
			carry=sum / 10;
			node.next=add(root1.next,root2.next,carry);
		}
		
		return node;
	}
	
	

	public static ListNode reverse(ListNode head) {
		ListNode prevNode=null;
		ListNode currNode=head;
		while(currNode !=null) {
			ListNode next=currNode.next;
			currNode.next=prevNode;
			prevNode=currNode;
			currNode=next;
		}
		return prevNode;
	}

}
