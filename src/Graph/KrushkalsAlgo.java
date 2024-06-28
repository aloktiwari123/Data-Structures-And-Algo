package Graph;
import java.util.*;
public class KrushkalsAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V=5;
		
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		int[][] edges={{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
	 	for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
        System.out.print(minimumSpanning(adj,V));
	}

	public static int minimumSpanning(ArrayList<ArrayList<ArrayList<Integer>>> adj,int V) {
		List<edge> edges = new ArrayList<edge>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                edge temp = new edge(i, adjNode, wt);
                edges.add(temp);
            }
        }
		Collections.sort(edges);
		DisjointSet set=new DisjointSet(V);
		int mst=0;
		for(int i=0;i<edges.size();i++) {
			int u=edges.get(i)._src;
			int v=edges.get(i)._des;
			int wt=edges.get(i)._wt;
			
			if(set.findUParent(u)!=set.findUParent(v)) {
				mst+=wt;
				set.unionBySize(u, v);
			}
		}
		return mst;
	}

}

class edge implements Comparable<edge>{
	int _src;
	int _des;
	int _wt;
	
	public edge(int src,int des,int wt) {
		this._src=src;
		this._des=des;
		this._wt=wt;
	}
	
	public int compareTo(edge edge) {
		// TODO Auto-generated method stub
		return this._wt-edge._wt;
	}
	
}
