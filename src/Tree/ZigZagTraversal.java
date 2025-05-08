package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

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
		boolean isrighttoleft=true;
		while(!pq.isEmpty()) {
			int level=pq.size();
			List<Integer>temp=new ArrayList<>(level);
			
			for(int i=0;i<level;i++) {
				TreeNode curr=pq.poll();
				if(curr.left!=null) pq.add(curr.left);
				if(curr.right!=null) pq.add(curr.right);
				temp.add(curr.val);
			}
			if(isrighttoleft) {
				wrap.add(temp);
			}
			else {
				Collections.reverse(temp);
				wrap.add(temp);
			}
			isrighttoleft=!isrighttoleft;
		}
		
		System.out.print(wrap);
	}
	
	
}

