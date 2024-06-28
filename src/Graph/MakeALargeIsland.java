package Graph;
import java.util.*;
public class MakeALargeIsland {
	
	public static void main(String args[]) {
		int[][] grid = {
	            {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
	            {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
	            {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
	        };
		int n=grid.length;
		int m=grid[0].length;
		System.out.print(solve(grid,n,m));
	}
	
	public static boolean isValid(int x,int y,int n,int m) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	
	public static int solve(int[][] grid,int n,int m) {
		DisjointSet set=new DisjointSet(n*m);
		int[][] moves= {{1,0},{-1,0},{0,1},{0,-1}};
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==0) {
					continue;
				}
				for(int[] move:moves) {
					int newX=i+move[0];
					int newY=j+move[1];
					if(isValid(newX,newY,n,m)) {
						if(grid[newX][newY]==1) {
							int nodeNo = i * m + j;
	                        int adjNodeNo = newX * m + newY;
	                        if(set.findUParent(nodeNo)!=set.findUParent(adjNodeNo)) {
	                        	set.unionBySize(nodeNo,adjNodeNo);
	                        }
						}
					}
				}
			}
		}
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1) {
					continue;
				}
				HashSet<Integer> components = new HashSet<>();
				for(int[] move:moves) {
					int newX=i+move[0];
					int newY=j+move[1];
					if(isValid(newX,newY,n,m)) {
						if(grid[newX][newY]==1) {
	                        int adjNodeNo = newX * m + newY;
	                        components.add(set.findUParent(adjNodeNo));
						}
					}
				}
				int size=0;
				for(int comp:components) {
					size+=set.size.get(comp);
				}
				max=Math.max(max, size+1);
			}
		}
		
		// case when no "0" are contained
		for (int i = 0;i < n * m; i++) {
            max = Math.max(max, set.size.get(set.findUParent(i)));
        }
		return max;
	}
	

}
