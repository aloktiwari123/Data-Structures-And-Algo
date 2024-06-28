package allpermutation;

import java.util.ArrayList;
import java.util.List;

public class allpermu_list {

		public static List<List<Integer>> permu(int[] no)
		{
			if(no.length==0)
			{
				List<List<Integer>> a=new ArrayList<List<Integer>>();
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
			List<List<Integer>> permwithoutfirst=permu(n2);
			List<List<Integer>> permwithfirst=new ArrayList<List<Integer>>();
			for(int i=0;i<permwithoutfirst.size();i++)
			{
				for(int j=0;j<=permwithoutfirst.get(i).size();j++)
				{
                    List<Integer> dummy  = new ArrayList<Integer>();
                    dummy.addAll(permwithoutfirst.get(i));
					dummy.add(j,n1);
					permwithfirst.add(dummy);
				}
			}
			return permwithfirst;
		
		}
		public  static void main(String args[]) {
			int[] n= {1,2,3};
			System.out.print(permu(n));
		}
	}

