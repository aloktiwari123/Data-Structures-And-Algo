package Graph;

public class OpsToMakeNetworkConnected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
		
		if(connections.length<n-1) System.out.print(-1);
		DisjointSet set=new DisjointSet(n-1);
		for(int[] conn:connections) {
			set.unionBySize(conn[0],conn[1]);
		}
		int c=0;
		for(int i=0;i<n;i++) {
			if(set.findUParent(i)==i) {
				c++;
			}
		}
		System.out.print(set.parent);
		System.out.print(c-1);
		
	}

}
