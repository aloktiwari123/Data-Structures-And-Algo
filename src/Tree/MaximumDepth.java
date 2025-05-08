package Tree;

public class MaximumDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		TreeNode head=BuildTree.buildTree(root);
		System.out.println(solve(head));
		System.out.println(sum(head));
	}
	
	public static int solve(TreeNode node) {
		if(node == null) return 0;
		
		int left=solve(node.left);
		int right=solve(node.right);
		int temp=Math.max(left, right)+1;
		
		return temp;
	}
	
	public static int sum(TreeNode node) {
		if(node == null) return 0;
		
		int left=sum(node.left);
		int right=sum(node.right);
		
		return left+right+node.val;
	}

}
