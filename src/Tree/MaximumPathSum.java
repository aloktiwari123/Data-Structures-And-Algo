package Tree;

public class MaximumPathSum {

	static int res=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {-10,9,20,0,0,15,7};
		TreeNode head=BuildTree.buildTree(root);
		solve(head);
		System.out.print(res);
	}

	
	public static int solve(TreeNode root) {
		if(root==null) return 0;
		
		int left=solve(root.left);
		int right=solve(root.right);
		
		int temp=Math.max(Math.max(left, right)+root.val,root.val);
		int ans=Math.max(temp,left+right+root.val);
		res=Math.max(res,ans);
		return temp;
		
	}

}
