package Graph;

public class NumberOfEnclaves {
	static boolean[][] visited;
	public static void main(String args[]) {
		int[][]grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
		System.out.print(solve(grid));
	}
	public static int solve(int[][] board){
		int n=board.length;
		int m=board[0].length;
		visited=new boolean[n][m];
		
		for(int i=0;i<m;i++) {
			if(board[0][i]==1 && !visited[0][i]) {
				dfs(0,i,board);
			}
			if(board[n-1][i]==1 && !visited[n-1][i]) {
				dfs(n-1,i,board);
			}
		}
		
		for(int i=0;i<n;i++) {
			if(board[i][0]==1 && !visited[i][0]) {
				dfs(i,0,board);
			}
			if(board[i][m-1]==1 && !visited[i][m-1]) {
				dfs(i,m-1,board);
			}
		}
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] && board[i][j]==1) {
					count++;
				}
			}
		}
		return count;
		
	}
	
	public static void dfs(int x,int y,int[][] board) {
		if(x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]==0 || visited[x][y]) {
			return;
		}
		int[][] moves= {{0,1},{1,0},{0,-1},{-1,0}};
		visited[x][y]=true;
		for(int i=0;i<moves.length;i++) {
			int newX=x+moves[i][0];
			int newY=y+moves[i][1];
			dfs(newX,newY,board);
		}
		
	}
	

}
