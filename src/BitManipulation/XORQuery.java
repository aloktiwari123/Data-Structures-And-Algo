package BitManipulation;

public class XORQuery {
	
	public static void main(String args[]) {
		 int[] arr = {1,3,4,8};
		 int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
		 solve(arr,queries);
	}
	
	/**
	 *  prefixXOR[0]=0(XOR of elements before the start)
		prefixXOR[1]=a
		prefixXOR[2]=a^b
		prefixXOR[3]=a^b^c
		prefixXOR[4]=a^b^c^d
		prefixXOR[5]=a^b^c^d^e
		
		To query the XOR from index 1 to 3:
		
		prefixXOR[4]=a^b^c^d
		
		prefixXOR[1]=a
		
	 * @param arr
	 * @param queries
	 */
	
	public static void solve(int[]arr,int[][] queries) {
		int[] prefixXOR=new int[queries.length+1];
		for(int i=0;i<arr.length;i++) {
			prefixXOR[i+1]=arr[i]^prefixXOR[i];
		}
		int[] res=new int[queries.length];
		for(int i=0;i<queries.length;i++) {
			res[i]=prefixXOR[queries[i][1]+1]^prefixXOR[queries[i][0]];
		}
	}

}
