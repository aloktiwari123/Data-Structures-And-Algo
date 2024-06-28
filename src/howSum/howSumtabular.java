package howSum;
import java.util.*;
public class howSumtabular {

	public static ArrayList<Integer> howsum(int target,int[] no)
	{
		ArrayList[] arr=new ArrayList[target+1];
		Arrays.fill(arr,null);
		
		ArrayList<Integer>n=new ArrayList<Integer>();
		arr[0]=n;
		
		for(int i=0;i<=target;i++)
		{
			if(arr[i] != null)
			{ 
				for(int j=0;j<no.length;j++)
				{
					if(i+no[j]<=target)
					{
					ArrayList<Integer>e=new ArrayList<Integer>();
					for(int k=0;k<arr[i].size();k++)
					{
						e.add((Integer) arr[i].get(k));
					}
					
					e.add(no[j]);
					arr[i+no[j]]=e;
					}
				}
			}
		}
		return arr[target];
		
	}
	public static  void main(String args[]) {
		int[] n= {2,3};
		System.out.print(howsum(7,n));
	}
}
