package howSum;
import java.util.*;

public class howSum {
 //public static ArrayList<int[]> arr=new ArrayList();
 
 public static ArrayList<Integer> howsum(int targetsum,ArrayList<Integer> no)
 {
	if(targetsum==0)
	{
		ArrayList<Integer> b=new ArrayList<Integer>();
		return b;
	}
	if(targetsum<0)
	{
		return null;
	}
	for(int i=0;i<no.size();i++)
	{
		int rem=targetsum-(int)no.get(i);
		//System.out.println(rem);
		ArrayList<Integer> remresult=howsum(rem, no);
		if(remresult !=null)
		{
			remresult.add((int)no.get(i));
			return(remresult);
		}
	}
	return null;
	 
 }

public static  void main(String args[]) {
	ArrayList<Integer> arr=new ArrayList<Integer>();
	arr.add(7);
	arr.add(14);
	//arr.add(4);
	//arr.add(7);
	System.out.print(howsum(300,arr));
}
}