package allcombinations;

import java.util.ArrayList;

public class allcombinations {

	public static ArrayList<ArrayList<Integer>>comb(int[] no) 
	{
		if(no.length==0)
		{
			ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> b=new ArrayList<Integer>();
			a.add(b);
			return a;
		}
		int n1=no[0];
		int[] n2=new int[no.length-1];
		for(int i=1;i<no.length;i++)
		{
			n2[i-1]=no[i];
		}
		ArrayList<ArrayList<Integer>>combwithoutfirst=comb(n2);
		ArrayList<ArrayList<Integer>>combwithfirst=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<combwithoutfirst.size();i++)
		{
			ArrayList<Integer>s=(ArrayList<Integer>)combwithoutfirst.get(i).clone();
			ArrayList<Integer>s2=(ArrayList<Integer>)combwithoutfirst.get(i).clone();
			combwithfirst.add(s2);
			s.add(n1);
			combwithfirst.add(s);
		
		}
        
		return combwithfirst;
	}
	public  static void main(String args[]) {
		int[] n= {1,2,3};
		System.out.print(comb(n));
	}
}
