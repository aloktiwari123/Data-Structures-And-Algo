package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TraversalDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		TreeNode head=BuildTree.buildTree(root);
		InOrderTravesal(head);
	}
	
	public static void InOrderTravesal(TreeNode node) {
		if(node == null) return;
		
		InOrderTravesal(node.left);
		System.out.print(node.val);
		InOrderTravesal(node.right);
		
	}
	
	public static void PreOrderTravesal(TreeNode node) {
		if(node == null) return;
		
		System.out.print(node.val);
		InOrderTravesal(node.left);
		InOrderTravesal(node.right);
		
	}
	
	public static void PostOrderTravesal(TreeNode node) {
		if(node == null) return;
		
		
		InOrderTravesal(node.left);
		InOrderTravesal(node.right);
		System.out.print(node.val);
		
	}

}
