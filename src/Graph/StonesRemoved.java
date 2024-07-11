//package Graph;
//import java.util.*;
//public class StonesRemoved {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
//		int[][] 
//		
//		for(int[] stone:stones) {
//			List<Integer> li=map.getOrDefault(stone[0],new ArrayList<>());
//			li.add(stone[1]);
//			map.put(stone[0],li);
//		}
//		System.out.print(map);
//	}
//	
//	public static int solve(HashMap<Integer,List<Integer>> map,int[][] stones) {
//		
//		
//		return 0;
//	}
//	
//	public List<int[]> bfs(HashMap<Integer,List<Integer>> map,int[] stone){
//		Queue<int[]> pq=new LinkedList<>();
//		pq.add(stone);
//		List<int[]> ans=new ArrayList<>();
//		while(!pq.isEmpty()) {
//			int[] node=pq.poll();
//			
//			if(map.containsKey(node[0]) && map.get(node[0]).size()==1) {
//				continue;
//			}
//			else {
//				ans.add(node);
//				map.get(node[0]).remove(node[1]);
//				if(map.get(node[0]).size()==0) map.remove(node[0]);
//				//List<Integer>n1=map.get(node[0]);
//				//List<Integer>n2=map.get(node[1]);
//				for()
//			}
//		}
//		return null;
//	}
//
//}
