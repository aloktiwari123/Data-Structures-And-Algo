package sliding_Var_Window;

public class countNumberOfNiceSubarray {
	
	public static void main(String args[]) {
		int[] arr= {2,2,2,1,2,2,1,2,2,2};
		System.out.print(solve(arr,2)-solve(arr,1));
	}
	
	public static int solve(int[] arr, int k) {
		int i=0;
		int j=0;
		int count=0;
		int oddCount=0;
		while(j<arr.length){
			if(arr[j]%2!=0) {
				oddCount+=1;
			}
			if(oddCount<=k) {
				count+=(j-i+1);
				j++;
			}
			else if(oddCount>k) {
				while(oddCount>k) {
					if(arr[i]%2!=0) {
						oddCount-=1;
					}
					i++;
				}
				count+=(j-i+1);
				j++;
			}
		}
		return count;
		
	}

}
