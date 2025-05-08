package Tree;

import java.util.*;

public class Forests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		int[] to_delete = {3,5};
		
		TreeNode head=BuildTree.buildTree(root);
		solve(head,to_delete);
	}
	
	public static List<TreeNode> solve(TreeNode root,int[] delete){
		HashSet<Integer>set=new HashSet<>();
		for(int n:delete) {
			set.add(n);
		}
		
		List<TreeNode> list=new ArrayList<>();
		root=getForest(root,set,list);
		 if (root != null) {
	            list.add(root);
	        }
		System.out.print(list);
		return list;
		
	}
	
	public static TreeNode getForest(TreeNode node,HashSet<Integer>set,List<TreeNode>forest){
		if(node==null) return null;
		
		node.left=getForest(node.left,set,forest);
		node.right=getForest(node.right,set,forest);
		
		if(set.contains(node.val)) {
			
			if(node.left!=null) {
				forest.add(node.left);
			}
			
			if(node.right!=null) {
				forest.add(node.right);
			}
			
			return null;
		}
		
		return node;
	}
	
}
