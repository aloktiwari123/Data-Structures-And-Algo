package LinkedList;


public class Add1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l1 = {9,9,9,9};
		ListNode node1=new ListNode(l1[0],null);
		ListNode root1=node1;
		for(int i=1;i<l1.length;i++) {
			ListNode nextNode=new ListNode(l1[i],null);
			node1.next=nextNode;
			node1=nextNode;
		}
		
		System.out.println(solve(root1, 0));
	}
	
	public static ListNode solve(ListNode node,int carry) {
		if(node==null) {
			return carry==0?null:new ListNode(carry);
		}
		ListNode res=new ListNode(0);
		int val=(node.val+1+carry)%10;
		carry=(node.val+1+carry)/10;
		res.val=val;
		res.next=solve(node.next, carry);
		return res;
	}

}
