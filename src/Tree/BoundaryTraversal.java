package Tree;
import java.util.*;
public class BoundaryTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		TreeNode head=BuildTree.buildTree(root);
		ArrayList<Integer>list=new ArrayList<>();
		if(!isLeaf(head)) list.add(head.val);
		addAllLeft(head,list);
		addLeaves(head,list);
		addAllRight(head,list);
		System.out.print(list);
	}
	
	public static boolean isLeaf(TreeNode root) {
		return root.left==null && root.right==null?true:false;
	}
	
	public static void addAllLeft(TreeNode root,ArrayList<Integer>res) {
		TreeNode curr=root.left;
		
		while(curr!=null) {
			if(!isLeaf(curr)) res.add(curr.val);
			
			if(curr.left!=null) curr=curr.left;
			else curr=curr.right;
		}
		
	}
	
	public static void addAllRight(TreeNode root,ArrayList<Integer>res) {
		TreeNode curr=root.right;
		ArrayList<Integer>temp=new ArrayList<>();
		
		while(curr!=null) {
			if(!isLeaf(curr)) temp.add(curr.val);
			
			if(curr.right!=null) curr=curr.right;
			else curr=curr.left;
		}
		
		for(int i=temp.size()-1;i>=0;i--) {
			res.add(temp.get(i));
		}
		
	}

	public static void addLeaves(TreeNode root,ArrayList<Integer>res) {
		if(isLeaf(root)) {
			res.add(root.val);
			return;
		}
		
		if(root.left !=null) addLeaves(root.left,res);
		if(root.right !=null) addLeaves(root.right,res);
	}
}
