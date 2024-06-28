package grid_traveler;
import java.util.*;
public class grid_dynamic {
    public static Hashtable<String,Integer>map=new Hashtable<>();
    
    public static int grid(int m,int n)
    {
    	String s=m+""+n;
    	if(map.containsKey(s))
    	{
    		return map.get(s);
    	}
    	if(m==1 && n==1)
    	{
    		return 1;
    	}
    	if(m==0 || n==0)
    	{
    		return 0;
    	}
        int value=grid(m-1,n)+grid(m,n-1);
        map.put(s,value);
        return value;
    }
    
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the dimensions");
    	int m=sc.nextInt();
    	int n=sc.nextInt();
    	
    	System.out.println(grid(m,n));
    }
}
