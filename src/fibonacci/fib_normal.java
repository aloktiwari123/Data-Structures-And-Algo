package fibonacci;
import java.util.*;
public class fib_normal {
	
	public static int fib(int n)
	{
		if(n<=2)
		{
			return 1;
		}
		return fib(n-1)+fib(n-2);
	}
	
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the no");
		int n=sc.nextInt();
		System.out.println(fib(n));
		
				
	}

}
