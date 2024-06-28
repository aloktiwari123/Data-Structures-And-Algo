package grid_traveler;
import java.util.*;

public class grid_travel {
	
	public static int grid(int m,int n)
	{
		if(m==1 && n==1) //base case
		{
			return 1;
		}
		if(m==0 || n==0) //grid empty
		{
			return 0;
		}
		
		return grid(m-1,n)+grid(m,n-1);
	}
	
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Input the dimensions");
		int m=sc.nextInt();
		int n=sc.nextInt();
		System.out.println(grid(m,n));
	}

}
