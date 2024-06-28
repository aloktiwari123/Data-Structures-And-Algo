package canConcat;
import java.util.*;
public class canConcat {

	public static boolean canconcat(String target,ArrayList<String>word)
	{
		if(target.isEmpty())
		{
			return true;
		}
		for(int i=0;i<word.size();i++)
		{
			if(target.indexOf(word.get(i))==0)
			{
			  String s=target.substring(word.get(i).length());
			  if(canconcat(s, word)==true)
			  {
				  return true;
			  }
			}
		}
		return false;
		
	}
	public static void main(String args[]) {
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("bo");
		arr.add("rd");
		arr.add("ate");
		arr.add("t");
		arr.add("ska");
		arr.add("sk");
		arr.add("boar");
		System.out.println(canconcat("skateboard",arr));	
	}
}
