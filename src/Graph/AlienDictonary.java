package Graph;

import java.util.*;

public class AlienDictonary {
	
	static int[] inDegree;
	public static void main(String args[]) {
		int N=5;
		int K=4;
		String [] dic= {"baa","abcd","abca","cab","cad"};
		System.out.print(dic(dic,N,K));
	}
	
	public static  List<Character>  dic(String[] dic,int N,int K){
		List<List<Integer>>adj=new ArrayList<>();
		inDegree=new int[K];
		for(int i=0;i<K;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<N-1;i++) {
			String s1=dic[i];
			String s2=dic[i+1];
			for(int j=0;j<s1.length();j++) {
				if(s1.charAt(j)!=s2.charAt(j)) {
					adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
					break;
				}
			}
		}
		
		for(int i=0;i<K;i++) {
			for(int adjNode:adj.get(i)) {
				inDegree[adjNode]++;
			}
		}
		
		return topoSort(adj);
		
	}
	
	public static List<Character> topoSort(List<List<Integer>>adj){
		Queue<Integer>queue=new LinkedList<>();
		for(int i=0;i<adj.size();i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}
		}
		List<Character>list=new ArrayList<>();
		while(!queue.isEmpty()) {
			int node=queue.poll();
			list.add((char)(node+'a'));
			for(int adjNode:adj.get(node)) {
				inDegree[adjNode]--;
				if(inDegree[adjNode]==0) {
					queue.add(adjNode);
				}
			}
		}
		return list;
	}

}
