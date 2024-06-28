package Graph;

public class DetectCycle2DMatrix {

	static boolean[][] visited;
	public static void main(String args[]) {
		char grid[][]={{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
		visited=new boolean[grid.length][grid[0].length];
		System.out.print(detectCycle(grid));
		
	}
	
	public static boolean detectCycle(char grid[][]) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(!visited[i][j]) {
					if(dfs(grid,i,j,-1,-1)==true) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean dfs(char grid[][],int x,int y,int sx,int sy) {
		int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
		visited[x][y]=true;
		boolean status=false;
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			
			if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==grid[x][y]) {
				if(!visited[nx][ny]) {
					status=status || dfs(grid,nx,ny,x,y);
				}
				else if(nx!=sx && ny!=sy) { // its visited and we do not came from it
					return true;
				}
			}
		}
		return status;
	}
}
