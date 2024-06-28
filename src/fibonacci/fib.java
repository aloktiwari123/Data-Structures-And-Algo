package fibonacci;
// Dynamic approach for fibonaaci series
import java.util.*;
public class fib {
	public static Hashtable<Integer,Integer>map=new Hashtable<>();
	
	public static int fib_n(int n)
	{
		if(map.containsKey(n))
		{
			return map.get(n);
		}
		if(n<=2)
		{
			return 1;
		}
		int value=fib_n(n-1)+fib_n(n-2);
		map.put(n, value);
		return value;
	}
	
	public static void main(String args[]) 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Input the no");
		int n=sc.nextInt();
		System.out.println(fib_n(n));
	}

}
