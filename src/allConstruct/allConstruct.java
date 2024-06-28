package allConstruct;
import java.util.*;
public class allConstruct {
	
	public static ArrayList<ArrayList<String>> allconstruct(String target,ArrayList<String>words)
	{
		if(target.isEmpty())
		{
			ArrayList<ArrayList<String>>b=new ArrayList<ArrayList<String>>();
			ArrayList<String>a=new ArrayList<String>();
			b.add(a);
			return b;
		}
		ArrayList<ArrayList<String>>totalways=new ArrayList<ArrayList<String>>();
		for(int i=0;i<words.size();i++)
		{
			if(target.indexOf(words.get(i))==0)
			{
				ArrayList<ArrayList<String>>suffixways=allconstruct(target.substring(words.get(i).length()), words);
				
				for(int j=0;j<suffixways.size();j++)
				{
					suffixways.get(j).add(0,words.get(i));
					totalways.add(suffixways.get(j));
				}
			    
			}
		}
		return totalways;
		
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
		System.out.println(allconstruct("purple",arr));
	}

}
