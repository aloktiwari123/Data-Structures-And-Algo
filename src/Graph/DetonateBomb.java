package Graph;
import java.util.*;
public class DetonateBomb {

	static HashMap<Integer,Boolean> isdetonated;
	public static void main(String args[]) {
		//int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
		int[][] bombs= {{1,1,5},{10,10,5}};
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<bombs.length;i++) {
			List<Integer>temp=new ArrayList<>();
			for(int j=0;j<bombs.length;j++) {
				if(i!=j) {
					int distance=(int) Math.ceil(Math.sqrt(Math.pow(bombs[j][0]-bombs[i][0], 2)+Math.pow(bombs[j][1]-bombs[i][1], 2)));
					if(distance<=bombs[i][2]) {
						temp.add(j);
					}
				}
			}
			adj.add(temp);
		}
		System.out.print(detonate(adj));
	}
	
	public static int detonate(List<List<Integer>>adj) {
		int max=1;
		
		for(int i=0;i<adj.size();i++) {
			isdetonated=new HashMap<>();
			dfs(adj,i);
			max=Math.max(max,isdetonated.size());
		}
		return max;
	}

	
	public static void  dfs(List<List<Integer>>adj,int node) {
		isdetonated.put(node,true);
		
		for(int adjNode : adj.get(node)) {
			if(!isdetonated.containsKey(adjNode)) {
				dfs(adj,adjNode);
			}
		}
	}
}
