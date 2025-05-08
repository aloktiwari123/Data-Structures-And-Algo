package Tree;

public class PathSum {
	
	static int sum=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] root = {1,0,1,0,1,0,1};
		TreeNode head=BuildTree.buildTree(root);
		solve(head,"");
		System.out.print(sum);
	}
	
	public static void solve(TreeNode node,String s) {
		if(node == null) {
			return;
		}
		s+=node.val;
		if(node.left==null && node.right==null) {
			sum+=toInt(s);
		}
		solve(node.left,s);
		solve(node.right,s);
	}
	
	public static int toInt(String s) {
		int sum=0;
		StringBuilder st=new StringBuilder(s);
		st.reverse();
		
		for(int i=0;i<st.length();i++) {
			sum+=(st.charAt(i)-'0')*Math.pow(2, i);
		}
		
		return sum;
	}
	

}
