package sliding_Window;

public class subArrayWithAvg {
	public static void main(String args[]) {
		int[] arr= {11,13,17,23,29,31,7,5,2,3};
		int k=3;
		int thresh=5;
		System.out.println(solve(arr,k,thresh));
		
	}
	
	public static int solve(int[] arr, int k, int thresh) {
		int i=0;
		int j=0;
		int sum=0;
		int count=0;
		
		while(j<arr.length) {
			sum=sum+arr[j];
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				if(sum>=thresh*k) {
					count+=1;
				}
				sum=sum-arr[i];
				i++;
				j++;
			}
		}
		return count;
	}

}
