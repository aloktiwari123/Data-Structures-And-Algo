package stack;
import java.util.*;
public class DE_Shaw_Regions {
	
	public static void main(String args[]) {
		List<Integer>heights=new ArrayList<Integer>() {{
			add(1);
			add(1);
			add(1);
			add(1);
		}};
		int sum=0;
		for(int i=0;i<heights.size();i++) {
			sum+=solveL(heights,i)+solveR(heights,i)+1;
		}
		System.out.print(sum);
	}
	
	public static int solveL(List<Integer> heights,int c){
		int count=0;
		int val=heights.get(c);
		c=c-1;
		while(c>=0 && heights.get(c)<=val) {
			count++;
			c--;
		}
		return count;
	}
	
	public static int solveR(List<Integer> heights,int c){
		int count=0;
		int val=heights.get(c);
		c=c+1;
		while(c<heights.size() && heights.get(c)<=val) {
			count++;
			c++;
		}
		return count;
	}

}
