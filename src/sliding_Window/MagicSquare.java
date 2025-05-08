package sliding_Window;

import java.util.HashSet;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
		System.out.print(solve(grid));
	}
	
	public static int solve(int[][] grid) {
		int ans=0;
		int n=grid.length;
		int m=grid[0].length;
		for(int i=0;i+2<n;i++) {
			for(int j=0;j+2<m;j++) {
				if(isMagicSquare(grid,i,j)) {
					ans++;
				}
			}
		}
		
		return ans;
	}

	private static boolean isMagicSquare(int grid[][],int row,int column) {
		// TODO Auto-generated method stub
		HashSet<Integer>set=new HashSet<>();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int num=grid[row+i][column+j];
				if(num<1 || num>9) return false;
				if(set.contains(num)) return false;
				set.add(num);
			}
		}
		
		int diagonal1=grid[row][column]+grid[row+1][column+1]+grid[row+2][column+2];
		int diagonal2=grid[row][column+2]+grid[row+1][column+1]+grid[row+2][column];
		
		if(diagonal1 !=diagonal2) return false;
		
		int row1=grid[row][column]+grid[row][column+1]+grid[row][column+2];
		int row2=grid[row+1][column]+grid[row+1][column+1]+grid[row+1][column+2];
		int row3=grid[row+2][column]+grid[row+2][column+1]+grid[row+2][column+2];
		
		if(!(row1 == diagonal1 && row2 == diagonal1 && row3 == diagonal1)) return false;
		
		
		int column1=grid[row][column]+grid[row+1][column]+grid[row+2][column];
		int column2=grid[row][column+1]+grid[row+1][column+1]+grid[row+2][column+1];
		int column3=grid[row][column+2]+grid[row+1][column+2]+grid[row+2][column+2];
		
		if(!(column1 == diagonal1 && column2 == diagonal1 && column3 == diagonal1 )) return false;
		
		return true;
	}

}
