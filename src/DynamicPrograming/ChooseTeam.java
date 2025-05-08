package DynamicPrograming;
import java.util.*;
public class ChooseTeam {

	static List<List<Integer>>res=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rating = {2,5,3,4,1};
		solveInc(3,rating,0,new ArrayList<>());
		solveDec(3,rating,0,new ArrayList<>());
		System.out.print(res);
	}
	
	public static void solveInc(int n,int[] rating,int x,List<Integer>list) {
		if(n==0 || x==rating.length) {
			if(n==0 && !res.contains(list)) res.add(list);
			return ;
		}
	if(list.isEmpty()) {
		List<Integer>temp=new ArrayList<>(list);
		temp.add(rating[x]);
		solveInc(n-1,rating,x+1,temp);
	}
	else {
		int val = list.get(list.size()-1);
		if(rating[x]<val) {
			List<Integer>temp=new ArrayList<>(list);
			temp.add(rating[x]);
			solveInc(n-1,rating,x+1,temp);
		}
	}
	solveInc(n,rating,x+1,new ArrayList<>(list));
	}

	public static void solveDec(int n,int[] rating,int x,List<Integer>list) {
		if(n==0 || x==rating.length) {
			if(n==0 && !res.contains(list)) res.add(list);
			return ;
		}
	if(list.isEmpty()) {
		List<Integer>temp=new ArrayList<>(list);
		temp.add(rating[x]);
		solveDec(n-1,rating,x+1,temp);
	}
	else {
		int val = list.get(list.size()-1);
		if(rating[x]>val) {
			List<Integer>temp=new ArrayList<>(list);
			temp.add(rating[x]);
			solveDec(n-1,rating,x+1,temp);
		}
	}
	solveDec(n,rating,x+1,new ArrayList<>(list));
	}
}
