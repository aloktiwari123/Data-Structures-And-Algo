package bestSum;
import java.util.*;

public class bestSum {
 //public static ArrayList<int[]> arr=new ArrayList();
 
 public static ArrayList<Integer> bestsum(int targetsum,ArrayList<Integer> no)
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
	ArrayList<Integer> tem=null;
	for(int i=0;i<no.size();i++)
	{
		int rem=targetsum-(int)no.get(i);
		//System.out.println(rem);
		ArrayList<Integer> remresult=bestsum(rem, no);
		if(remresult !=null)
		{
			remresult.add((int)no.get(i));
			if(tem  == null || remresult.size()<tem.size())
			{
			  tem=remresult;
			}
			
		}
	}
	return tem;
	 
 }

public static  void main(String args[]) {
	ArrayList<Integer> arr=new ArrayList<Integer>();
	arr.add(1);
	arr.add(4);
	arr.add(5);
	//arr.add(7);
	System.out.print(bestsum(8,arr));
	
}
}