package grid_traveler;
import java.util.*;
public class grid_tabular {

	public static int gridtabular(int n,int m)
	{
		int[][] arr=new int[n+2][m+2];
		arr[1][1]=1;
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				arr[i][j+1]+=arr[i][j];
				arr[i+1][j]+=arr[i][j];
				
			}
		}
		
		return arr[n][m];
		
	}
	public static void main(String args[])
	{
		System.out.print(gridtabular(3,3));
	}
}
