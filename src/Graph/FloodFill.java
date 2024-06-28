package Graph;
import java.util.*;
public class FloodFill {

	public static void main(String arg[]) {
		int[][] image= {{1,1,1},{1,1,0},{1,0,1}};
		solve(image,1,1,2);
		
	}
	
	public static int[][] solve(int[][] image,int sx,int sy,int color) {
		dfs(image,sx,sy,color,image[sx][sy]);
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
}
