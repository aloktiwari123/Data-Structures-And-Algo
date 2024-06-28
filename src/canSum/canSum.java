package canSum;
import java.util.Hashtable;
public class canSum {
	public static  Hashtable<Integer,Boolean>map=new Hashtable<>();
	public static boolean cansum(int targetsum,int[] no)
	{
		int rem;
		if(map.contains(targetsum))
		{
			return true;
		}
		if(targetsum == 0)
		{
			return true;
		}
		if(targetsum < 0)
		{
			return false;
		}
		
		for(int i=0;i<no.length;i++)
		{
			rem=targetsum-no[i];
			if(cansum(rem, no)==true)
			{
				map.put(targetsum,true);
				return true;
				
			}
		}
		return false;
		
	}
	public static void main(String args[]) {
		int[] arr= {2,3,4};
		System.out.print(cansum(300,arr));
	}

}
