package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

	
	public static TreeNode buildTree(int[] nums) {
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
