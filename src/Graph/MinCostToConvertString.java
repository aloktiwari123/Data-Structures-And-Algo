package Graph;
import java.util.*;

public class MinCostToConvertString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] original = {'a','b','c','c','e','d'};
		char[] changed = {'b','c','b','e','b','e'};
		int[] cost = {2,5,5,1,2,20};
		String source = "abcd";
		String target = "acbe";
		HashMap<Character,List<charNode>>adj=new HashMap<>();
		for(int i=0;i<original.length;i++) {
			List<charNode>temp=new ArrayList<>();
			if(adj.containsKey(original[i])) {
				temp=adj.get(original[i]);
				charNode newNode=new charNode(original[i],changed[i],cost[i]);
				for(charNode node:temp) {
					if(node.newChar==newNode.newChar && newNode.cost<node.cost) {
						node.cost=newNode.cost;
					}
				}
				temp.add(new charNode(original[i],changed[i],cost[i]));
			}
			else {
				temp.add(new charNode(original[i],changed[i],cost[i]));
			}
			adj.put(original[i],temp);
		}
		//System.out.print(adj);
		//System.out.print(shortestPath(adj,'c'));
		long[][]costs=new long[26][26];
		for(int i=0;i<26;i++) {
			costs[i]=shortestPathArray(adj,(char)(i+'a'));
		}
		long totalcost=0;
		for(int i=0;i<target.length();i++) {
			char orig=source.charAt(i);
			char des=target.charAt(i);
			if(costs[orig-'a'][des-'a']==Long.MAX_VALUE) {
				System.out.print(-1);
				break;
			}
			totalcost+=costs[orig-'a'][des-'a'];
		}
		System.out.print(totalcost);
	}
	
	
	public static long[] shortestPathArray(HashMap<Character,List<charNode>>adj,char src){
		PriorityQueue<charNode>pq=new PriorityQueue<>((x,y)->(
				(int)y.cost-(int)x.cost));
		pq.add(new charNode(src,src,0));
		long[] disL=new long[26];
		Arrays.fill(disL,Long.MAX_VALUE);
		disL[src-'a']=0;
		while(!pq.isEmpty()) {
			charNode node=pq.poll();
			char currChar=node.newChar;
			long cost=node.cost;
			
			for(charNode adjNode:adj.getOrDefault(currChar,new ArrayList<>())) {
				if(cost+adjNode.cost<disL[adjNode.newChar-'a']) {
					disL[adjNode.newChar-'a']=cost+adjNode.cost;
					pq.add(new charNode(currChar,adjNode.newChar,disL[adjNode.newChar-'a']));
				}
			}
		}
		
		return disL;
	}

}






class charNode{
	char origChar;
	char newChar;
	long cost;
	
	public charNode(char a,char b,long cost) {
		this.origChar=a;
		this.newChar=b;
		this.cost=cost;
	}

	@Override
	public String toString() {
		return "charNode [origChar=" + origChar + ", newChar=" + newChar + ", cost=" + cost + "]";
	}

}
