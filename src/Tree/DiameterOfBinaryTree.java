package Tree;

public class DiameterOfBinaryTree {

	static int res=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		TreeNode head=BuildTree.buildTree(root);
		getDiameter(head);
		System.out.print(res);
	}
	
	public static int getDiameter(TreeNode root) {
		if(root==null) return 0;
		
		int left=getDiameter(root.left);
		int right=getDiameter(root.right);
		
		res=Math.max(res,left+right+1);
		
		return Math.max(left, right)+1;
		
	}

}
