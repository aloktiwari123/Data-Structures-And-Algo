package fibonacci;
import java.util.*;
public class fibtabular {

public static int fibtabula(int n)
{
	int[] arr=new int[n+2];
	Arrays.fill(arr,0);
	arr[1]=1;
	for(int i=0;i<n;i++)
	{
		arr[i+1]+=arr[i];
		arr[i+2]+=arr[i];
	}
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]);
	}
	
	return arr[n];
	
}
public static void main(String args[])
{
	System.out.print(fibtabula(6));
}
}
