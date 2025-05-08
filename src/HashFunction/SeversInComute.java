package HashFunction;

public class SeversInComute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,0},{1,1}};
		System.out.print(solve(grid));
	}
	
	public static int solve(int[][] grid) {
		int n=grid.length;
		int m=grid[0].length;
		int[] rowCount=new int[n];
		int[] columnCount=new int[m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1) {
					rowCount[i]++;
					columnCount[j]++;
				}
			}
		}
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1 && (rowCount[i]>1 || columnCount[j]>1)) {
					count++;
				}
			}
		}
		
		return count;
	}

}
