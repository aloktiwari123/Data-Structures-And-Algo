package sliding_Window;

public class maxSumSubarray {
	
	
	public static int max_SumSubarray_AV(int[] arr,int k) {
		int sum=0;
		int max=0;
		int j=0,i=0;
		while(j<arr.length) {
			sum+=arr[j];
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				max=Math.max(max, sum);
				sum=sum-arr[i];
				i++;
				j++;
			}
		}
		return max;
	}
	
	public static int max_SumSubarray(int[] arr,int k) {
		int window=0;
		int max=0;
		for(int i=0;i<k;i++) {
			window=window+arr[i];
		}
		for(int i=k;i<arr.length;i++) {
			window=window+arr[i]-arr[i-k];
			System.out.println(i +"_"+window);
			max=Math.max(max,window);
		}
		return max;
		
		
	}
	public static void main(String args[]) {
		int [] arr= {2,5,1,8,2,9,1};
		System.out.println(max_SumSubarray_AV(arr,3));
		
	}

}
