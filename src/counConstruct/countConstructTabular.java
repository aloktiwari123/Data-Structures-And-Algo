package counConstruct;

import java.util.ArrayList;
import java.util.Arrays;

public class countConstructTabular {

	public static int canconstruct(String target,String[] words)
	{
		int[] arr=new int[target.length()+1];
		Arrays.fill(arr,0);
		arr[0]=1;
		for(int i=0;i<=target.length();i++)
		{
			if(arr[i]!=0)
			{
				for(int j=0;j<words.length;j++)
				{
					if((i+words[j].length())<=target.length())
					{
					if(target.substring(i,i+words[j].length()).equalsIgnoreCase(words[j]))
					{
						arr[i+words[j].length()]+=arr[i];
					}}
				}
			}
		}
		return arr[target.length()];
		
	}
	public static void main(String args[]) {
		
		String[] words= {"purp","p","ur","le","purpl"};
		System.out.println(canconstruct("purple",words));	
	}
}
