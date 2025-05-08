package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class GoodLeafs {

	int n=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] root = {1,2,3,4};
		TreeNode head=buildTree(root);
		//solve(head,to_delete);
		System.out.print(head);
		System.out.print(solve(head));

	}
	
	
	public static int solve(TreeNode node) {
		if(node == null) return 0;
		
		int left=solve(node.left);
		int right=solve(node.right);
		
		return 1+Math.max(left, right);
		
	}
	
	
	public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode curr = q.remove();
            if (i < nums.length) {
                curr.left = new TreeNode(nums[i++]);
                q.add(curr.left);
            }
            if (i < nums.length) {
                curr.right = new TreeNode(nums[i++]);
                q.add(curr.right);
            }
        }
        return root;
    }

}
