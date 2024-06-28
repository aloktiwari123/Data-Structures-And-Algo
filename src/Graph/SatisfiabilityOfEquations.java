package Graph;
import java.util.*;
public class SatisfiabilityOfEquations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] equations = {"b==a","a==b"};
		System.out.print(solve(equations));
	}
	
	public static boolean solve(String[] equations) {
		DisjointSet set=new DisjointSet(equations.length);
		HashMap<String,Integer>map=new HashMap<>();
		List<int[]> nCases=new ArrayList<>();
		int c=-1;
		for(String equation:equations) {
			String op1="";
			String op2="";
			if(equation.contains("==")) {
				String[] temp=equation.split("==");
				op1=temp[0];
				op2=temp[1];
				int o1=map.containsKey(op1)?map.get(op1):++c;
				if(o1==c) map.put(op1,c);
				int o2=map.containsKey(op2)?map.get(op2):++c;
				if(o2==c) map.put(op2,c);
				if(set.findUParent(o1)!=set.findUParent(o2)) {
					set.unionBySize(o1,o2);
				}
				
			}
			else if(equation.contains("!=")) {
				String[] temp=equation.split("!=");
				op1=temp[0];
				op2=temp[1];
				int o1=map.containsKey(op1)?map.get(op1):++c;
				if(o1==c) map.put(op1,c);
				int o2=map.containsKey(op2)?map.get(op2):++c;
				if(o2==c) map.put(op2,c);
				nCases.add(new int[] {o1,o2});
			}
		}
		for(int[] temp:nCases) {
			if(set.findUParent(temp[0])==set.findUParent(temp[1])) return false;
		}
		return true;
	}

}
