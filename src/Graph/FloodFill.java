package Graph;
import java.util.*;
public class FloodFill {

	public static void main(String arg[]) {
		int[][] image= {{1,1,1},{1,1,0},{1,0,1}};
		solve(image,1,1,2);
		
	}
	
	public static int[][] solve(int[][] image,int sx,int sy,int color) {
		dfsSolve(image,sx,sy,color,image[sx][sy]);
		return image;
	}
	
	public static void dfs(int[][] image,int sx,int sy,int newColor,int sourceColor) {
		
		if(sx<0 || sx>=image.length || sy<0 || sy>=image[0].length || image[sx][sy]!=sourceColor ) {
			return ;
		}
		image[sx][sy]=newColor;
		
		dfs(image,sx-1,sy,newColor,sourceColor);
		dfs(image,sx+1,sy,newColor,sourceColor);
		dfs(image,sx,sy-1,newColor,sourceColor);
		dfs(image,sx,sy+1,newColor,sourceColor);
	}
	
	public static void dfsSolve(int[][] image,int sx,int sy,int newColor,int sourceColor) {
		image[sx][sy]=newColor;
		
		int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
		
		for(int[] dir:dirs) {
			int newX=sx+dir[0];
			int newY=sy+dir[1];
			
			if(isValid(image,newX,newY,sourceColor)) {
				dfsSolve(image,newX, newY,newColor ,sourceColor);
			}
		}
	}
	
	public static boolean isValid(int[][] image,int sx,int sy,int sourceColor) {
		if(sx>0 && sx<=image.length && sy>0 && sy<=image[0].length && image[sx][sy]==sourceColor ) {
			return true;
		}else {
			return false;
		}
	}
}
