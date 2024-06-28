package Graph;
import java.util.*;
public class EvaluateDivison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] equations ={{"a","b"},{"b","c"}};
		double[] values = {2.0,3.0};
		HashMap<String,List<Val>>edges=new HashMap<>();
		int c=0;
		for(String[] eq:equations) {
			if(!edges.containsKey(eq[0])) {
				edges.put(eq[0],new ArrayList<>());
			}
			if(!edges.containsKey(eq[1])) {
				edges.put(eq[1],new ArrayList<>());
			}
			edges.get(eq[0]).add(new Val(eq[1],values[c]));
			edges.get(eq[1]).add(new Val(eq[0],1/values[c]));
			c++;
		}
		String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
		double[] res=new double[queries.length];
		c=0;
		for(String[] query:queries) {
			res[c]=solve(edges,query[0],query[1]);
			c++;
		}
		System.out.print(Arrays.toString(res));
	}
	
	public static double solve(HashMap<String,List<Val>>edges,String src,String des) {
		HashMap<String,Double>dis=new HashMap<>();
		if(!edges.containsKey(src)|| !edges.containsKey(des)) {
			return -1.0;
		}
		for(Map.Entry<String,List<Val>>entry:edges.entrySet()) {
			dis.put(entry.getKey(),Double.MAX_VALUE);
		}
		dis.put(src,1.0);
		PriorityQueue<Val>queue=new PriorityQueue<>((a,b)->Double.compare(a.wt,b.wt));
		queue.add(new Val(src,1.0));
		while(!queue.isEmpty()) {
			Val node=queue.poll();
			for(Val adjNode:edges.get(node.v)) {
				if((node.wt*adjNode.wt)<dis.get(adjNode.v)) {
					dis.put(adjNode.v,node.wt*adjNode.wt);
					queue.add(new Val(adjNode.v,dis.get(adjNode.v)));
				}
			}
		}
		return dis.get(des);
	}

}

class Val{
	@Override
	public String toString() {
		return "Val [v=" + v + ", wt=" + wt + "]";
	}

	String v;
	double wt;
	
	Val(String v,Double wt){
		this.v=v;
		this.wt=wt;
	}
	
}
