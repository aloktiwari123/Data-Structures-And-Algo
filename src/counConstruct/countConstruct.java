package counConstruct;
import java.util.*;
public class countConstruct {

	public static int countconstruct(String target,ArrayList<String>word)
	{
		int total=0;
		if(target.isEmpty())
		{
			return 1;
		}
		for(int i=0;i<word.size();i++)
		{
			if(target.indexOf(word.get(i))==0)
			{
				String s=target.substring(word.get(i).length());
				int n=countconstruct(s, word);
				total+=n;
			}
		}
		return total;
		
	}
	public static void main(String args[]) {
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("purp");
		arr.add("p");
		arr.add("ur");
		arr.add("le");
		arr.add("purpl");
		//arr.add("sk");
		//arr.add("boar");
		System.out.println(countconstruct("purple",arr));	
	}
}
