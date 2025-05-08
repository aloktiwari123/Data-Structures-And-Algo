package Tree;
import java.util.*;

public class IterativeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		TreeNode head=BuildTree.buildTree(root);
		postOrderTravesal(head);
	}
	
	// root - left - right
	public static void preOrderTravesal(TreeNode node) {
		Stack<TreeNode>st=new Stack<>();
		st.add(node);
		
		while(!st.isEmpty()) {
			TreeNode temp=st.pop();
			if(temp.right!=null) st.add(temp.right);
			if(temp.left!=null) st.add(temp.left);
			System.out.print(temp.val);
		}
		
	}
	
	// left - root - right
	public static void inOrderTravesal(TreeNode node) {
		Stack<TreeNode>st=new Stack<>();
		
		while(true) {
			if(node !=null) {
				st.add(node);
				node=node.left;
			}
			else {
				if(st.isEmpty()) {
					break;
				}
				node=st.pop();
				System.out.print(node.val);
				node=node.right;
				
			}
			
		}
		
	}
	
	// left - right - root (using 2 stack)
	public static void postOrderTravesal(TreeNode node) {
		Stack<TreeNode>st1=new Stack<>();
		Stack<TreeNode>st2=new Stack<>();
		st1.add(node);
		while(!st1.isEmpty()) {
			TreeNode temp=st1.pop();
			if(temp.left !=  null) st1.add(temp.left);
			if(temp.right !=  null) st1.add(temp.right);
			st2.add(temp);
		}
		
		while(!st2.isEmpty()) {
			System.out.print(st2.pop().val);
		}
	}

}
