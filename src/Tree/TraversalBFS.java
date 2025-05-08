package Tree;
import java.util.*;

public class TraversalBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,2,3,4,5,6,7};
		TreeNode head=BuildTree.buildTree(root);
		LevelOrderTravesal(head);
	}
	
	public static void LevelOrderTravesal(TreeNode node) {
		Queue<TreeNode>pq=new LinkedList<>();
		List<List<Integer>>wrap=new ArrayList<>();
		pq.add(node);
		
		while(!pq.isEmpty()) {
			List<Integer>temp=new ArrayList<>();
			int level=pq.size();
			
			for(int i=0;i<level;i++) {
				TreeNode curr=pq.poll();
				if(curr.left!=null) pq.add(curr.left);
				if(curr.right!=null) pq.add(curr.right);
				temp.add(curr.val);
			}
			wrap.add(temp);
		}
		
		System.out.print(wrap);
	}

}
