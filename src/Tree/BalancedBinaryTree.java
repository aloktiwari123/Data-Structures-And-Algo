package Tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		TreeNode head=BuildTree.buildTree(root);
		System.out.print(balancedBinaryTree(head));
	}
	
	public static int balancedBinaryTree(TreeNode root) {
		if(root==null) {
			return 0;
		}
		
		int left=balancedBinaryTree(root.left);
		int right=balancedBinaryTree(root.right);
		
		if(left==-1 || right == -1) return -1;
		
		if(Math.abs(right-left)>1) return -1;
		
		return Math.max(left, right)+1;
	}

}
