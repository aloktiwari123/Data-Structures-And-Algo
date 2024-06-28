package allConstruct;

import java.util.ArrayList;
import java.util.Arrays;

public class allConstructTabular {
	
	public static ArrayList<ArrayList<String>> allconstruct(String target,String[]words)
	{
		ArrayList[] arr=new ArrayList[target.length()+1];
		ArrayList<ArrayList<String>>a=new ArrayList<ArrayList<String>>();
		ArrayList<String>b=new ArrayList<String>();
		a.add(b);
		arr[0]=a;
		for(int i=0;i<=target.length();i++)
		{
			if(arr[i] !=null)
			{
			   for(int j=0;j<words.length;j++)
			   {
				   if(i+words[j].length()<=target.length())
				   {
					   String sub=target.substring(i,i+words[j].length());
					   if(sub.equalsIgnoreCase(words[j]))
					   {
						   for(int k=0;k<arr[i].size()||k==0;k++)
						   {
							   
							   ArrayList<String> s=new ArrayList<String>();
							   //System.out.print(arr[i].get(k));
							   if(arr[i].size()==0||arr[i+words[j].length()]==null)
							   {
								   
								   ArrayList<ArrayList<String>>a1=new ArrayList<ArrayList<String>>();
								   ArrayList<String>b1=new ArrayList<String>();
								   b1.add(0,words[j]);
								   a1.add(b1);
								   arr[i+words[j].length()]=a1;
								   
							   }
							   else
							   {
								   ArrayList<ArrayList<String>>clone =(ArrayList<ArrayList<String>>)arr[i].clone();
								   s=(ArrayList<String>)clone.get(k);
								   s.add(words[j]);
								   ArrayList<ArrayList<String>>c2=(ArrayList<ArrayList<String>>)arr[i+words[j].length()].clone();
								   c2.add(s);
								   
								  
								   
							   }
							   
							   //
							   
						   }
					   }
					   
				   }
			   }
			}
		}
		System.out.print(Arrays.toString(arr));
		return arr[target.length()];
		
	}
	public static void main(String args[]) {
		
		String[] words= {"ab","abc","cd","def","abcd","ef","c"};
		System.out.println(allconstruct("abcdef",words));
	}
}
