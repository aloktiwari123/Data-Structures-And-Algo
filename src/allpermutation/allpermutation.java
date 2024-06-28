package allpermutation;

import java.util.ArrayList;

public class allpermutation {

	public static ArrayList<ArrayList<Integer>> permu(int[] no)
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
		ArrayList<ArrayList<Integer>> permwithoutfirst=permu(n2);
		ArrayList<ArrayList<Integer>> permwithfirst=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<permwithoutfirst.size();i++)
		{
			for(int j=0;j<=permwithoutfirst.get(i).size();j++)
			{
				ArrayList<Integer>s=(ArrayList<Integer>)permwithoutfirst.get(i).clone();
				s.add(j,n1);
				permwithfirst.add(s);
			}
		}
		return permwithfirst;
	
	}
	public  static void main(String args[]) {
		int[] n= {1,2,3};
		System.out.print(permu(n));
	}
}
