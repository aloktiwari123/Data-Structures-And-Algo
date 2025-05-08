package HashFunction;

import java.util.Arrays;
import java.util.HashMap;

public class NoDistinctColours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 4;
		int[][] queries = {{1,4},{2,5},{1,3},{3,4}};
		System.out.println(Arrays.toString(solve(limit,queries)));
	}
	
	public static int[] solve(int limit,int[][] queries) {
		HashMap<Integer,Integer>map=new HashMap<>();
		int[] ans=new int[queries.length];
		int[] balls=new int[limit+1];
		int c=0;
		for(int[] query:queries) {
			int idx=query[0];
			int color=query[1];
			if(balls[idx]!=0) {
				int prevColor=balls[idx];
				map.put(prevColor,map.get(prevColor)-1);
				
				if(map.get(prevColor)==0) {
					map.remove(prevColor);
				}
			}
		map.put(color,map.getOrDefault(color,0)+1);
		balls[idx]=color;

			ans[c]=map.size();
			c++;
		}
		return ans;
	}

}
