package canConcat;

import java.util.ArrayList;

public class canConstructTabular {

	public static boolean canconstruct(String target,String[] words)
	{
		boolean[] arr=new boolean[target.length()+1];
		arr[0]=true;
		for(int i=0;i<=target.length();i++)
		{
			if(arr[i]==true)
			{
				for(int j=0;j<words.length;j++)
				{
					if((i+words[j].length())<=target.length())
					{
					if(target.substring(i,i+words[j].length()).equalsIgnoreCase(words[j]))
					{
						arr[i+words[j].length()]=true;
					}}
				}
			}
		}
		
		return arr[target.length()];
		
	}
	public static void main(String args[]) {
		
		String[] words= {"ab","abc","cd","def","abcd"};
		System.out.println(canconstruct("abcdef",words));	
	}
}
