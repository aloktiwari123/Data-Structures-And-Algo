package LinkedList;
import java.util.*;
public class LocalMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] head = {5,3,1,2,5,1,2};
		ListNode node=new ListNode(5,null);
		ListNode root=node;
		for(int i=1;i<head.length;i++) {
			ListNode nextNode=new ListNode(head[i],null);
			node.next=nextNode;
			node=nextNode;
		}
		//System.out.println(root);
		System.out.print(Arrays.toString(solve(root)));
	}

	public static int[] solve(ListNode head) {
		int[] result=new int[] {-1,-1};
		ListNode prev=head;
		ListNode curr=head.next;
		int prevC=0;
		int firstC=0;
		int idx=1;
		int min=Integer.MAX_VALUE;
		while(curr.next!=null) {
			if((prev.val >curr.val && curr.next.val>curr.val) || (prev.val <curr.val && curr.next.val<curr.val)) {
				if(prevC==0) {
					prevC=idx;
					firstC=idx;
				}
				else {
					min=Math.min(idx-prevC, min);
					prevC=idx;
				}
			}
			prev=curr;
			curr=curr.next;
			idx+=1;
		}
		
		if(min!=Integer.MAX_VALUE) {
			int max=prevC-firstC;
			result=new int[] {min,max};
		}
		
		
		return result;
	}
}
