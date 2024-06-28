package Graph;
import java.util.*;
public class PathWithMaxProbability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] edges = {{0,1},{1,2},{0,2}};
		double[] succProb = {0.5,0.5,0.2};
		int start = 0;
		int end = 2;
		List<List<_pair>>adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		int c=0;
		for(int[] edge:edges) {
			adj.get(edge[0]).add(new _pair(edge[1],succProb[c]));
			adj.get(edge[1]).add(new _pair(edge[0],succProb[c]));
			c++;
		}
		System.out.print(solve(adj,start,end));
	}
	
	public static double solve(List<List<_pair>>adj,int start,int end) {
		PriorityQueue<_pair>pq=new PriorityQueue<>((a,b)->(Double.compare(b.wt,a.wt)));
		double[] prob=new double[adj.size()];
		pq.add(new _pair(start,1.0));
		prob[start]=1d;
		
		while(!pq.isEmpty()) {
			_pair node=pq.poll();
			int v=node.v;
			double wt=node.wt;
			if(v==end) return wt;
			for(_pair adjNode: adj.get(v)) {
				if(wt*adjNode.wt>prob[adjNode.v]) {
					prob[adjNode.v]=wt*adjNode.wt;
					pq.add(new _pair(adjNode.v,prob[adjNode.v]));
				}
			}
			
		}
		return 0d;
	}
	

	
}

class _pair{

	int v;
	double wt;
	
	public _pair(int v,double wt) {
		this.v=v;
		this.wt=wt;
	}
	
	@Override
	public String toString() {
		return "_pair [v=" + v + ", wt=" + wt + "]";
	}
}
