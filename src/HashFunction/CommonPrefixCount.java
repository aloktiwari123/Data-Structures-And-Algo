package HashFunction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonPrefixCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]A = {2,3,1};
		int[]B = {3,1,2};
		System.out.print(Arrays.toString(solve(A,B)));
	}
	
	public static int[] solve(int[] A,int[] B) {
		HashMap<Integer,Integer>map=new HashMap<>();
		int[]C=new int[A.length];
		for(int i=0;i<A.length;i++) {
			map.put(A[i],map.getOrDefault(A[i],0)+1);
			map.put(B[i],map.getOrDefault(B[i],0)+1);
			int count=0;
			for(Map.Entry<Integer,Integer>entry:map.entrySet()) {
				count+=entry.getValue()/2;
			}
			C[i]=count;
		}
		return C;
	}
}
