package Graph;
import java.util.*;
public class NumberOfIslands {

	public static void main(String args[]) {
		int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };
        System.out.print(solve(operators,n,m));

	}
	
	public static List<Integer> solve(int[][] ops,int n,int m){
		DisjointSet set=new DisjointSet(n*m);
		int[][] vis=new int[n][m];
		int count=0;
		List<Integer>ans=new ArrayList<>();
		int[][] moves= {{1,0},{-1,0},{0,1},{0,-1}};
		for(int i=0;i<ops.length;i++) {
			int r=ops[i][0];
			int c=ops[i][1];
			
			if(vis[r][c]==1) {
				ans.add(count);
				continue;
			}
			vis[r][c] = 1;
            count++;
			for(int[] move:moves) {
				int newR=r+move[0];
				int newC=c+move[1];
				if(newR>=0 && newR<n && newC>=0 && newC<m) {
					if(vis[newR][newC]==1) {
						int nodeNo = r * m + c;
                        int adjNodeNo = newR * m + newC;
                        if(set.findUParent(nodeNo)!=set.findUParent(adjNodeNo)) {
                        	count--;
                        	set.unionBySize(nodeNo,adjNodeNo);
                        }
					}
				}
			}
			ans.add(count);
		}
		return ans;
	}
}
