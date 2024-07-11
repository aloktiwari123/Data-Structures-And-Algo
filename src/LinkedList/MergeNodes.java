package LinkedList;

public class MergeNodes {

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
		System.out.println(root);
		System.out.print(solve(root));
		//System.out.print(rSolve(root));
	}
	
	public static ListNode solve(ListNode head) {
		ListNode root=head.next;
		ListNode nextSum=root;
		while(nextSum !=null) {
			int sum=0;
			while(nextSum.val!=0) {
				sum+=nextSum.val;
				nextSum=nextSum.next;
			}
			
			root.val=sum;
			nextSum=nextSum.next;
			root.next=nextSum;
			root=root.next;
			
		}
		return head.next;
	}
	
	public static ListNode rSolve(ListNode head) {
		head=head.next;
		if(head==null) {return head;}
		
		int sum=0;
		ListNode temp=head;
		
		while(temp.val !=0) {
			sum+=temp.val;
			temp=temp.next;
		}
		head.val=sum;
		head.next=rSolve(temp);
		return head;
	}
	
}
