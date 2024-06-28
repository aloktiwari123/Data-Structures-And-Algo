package canSum;

import java.util.Arrays;

public class canSumtabular {
	public static boolean cansum(int target,int[] no)
	{
		boolean[] arr=new boolean[target+1];
		Arrays.fill(arr,false);
		arr[0]=true;
		for(int i=0;i<=target;i++)
		{
			if(arr[i]==true)
			{
				for(int j=0;j<no.length;j++)
				{
					if(i+no[j]<=target)
					{
						arr[i+no[j]]=true;
					}
					
				}
			}
		}
		return arr[target];
		
	}
	public static void main(String args[]) {
		int[] n= {3,4,5};
		System.out.print(cansum(7, n));
		
	}
}
