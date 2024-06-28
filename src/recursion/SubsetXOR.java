package recursion;

public class SubsetXOR {
	
	
	public static void main(String args[]) {
		int[] nums= {5,1,6};
		System.out.print(subsetsXOR(nums,0,0));
	}
	
	public static int subsetsXOR(int arr[],int i,int temp) {
		if(i==arr.length) {
			return temp;
		}
		return subsetsXOR(arr,i+1,temp)+subsetsXOR(arr,i+1,temp^arr[i]);	
	}

}
