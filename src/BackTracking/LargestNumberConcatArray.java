package BackTracking;

public class LargestNumberConcatArray {

	static String max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[]= {3,30,34,5,9};
        max=getString(arr);
        solve(0,arr.length,arr);
        System.out.print(max);
	}
	
	public static void solve(int start,int end,int[] arr) {
		String s=getString(arr);
		if(s.compareTo(max)>0) {
			max=s;
		}
		if(start==end) {
			return ;
		}
		int maxN=getMax(start,arr);
		if(maxN!=-1) {
			for(int i=start+1;i<end;i++) {
				if((arr[i])==maxN) {
					swap(start,i,arr);
					solve(start+1,end,arr);
					swap(start,i,arr);
				}
			}
		}
		else {
			solve(start+1,end,arr);
		}

		
	}
	public static int getMax(int start,int[] arr) {
		int idx=String.valueOf(arr[start]).charAt(0)-'0';
		int max=idx;
		for(int i=start;i<arr.length;i++) {
			int val=String.valueOf(arr[i]).charAt(0)-'0';
			max=Math.max(max,val);
		}
		return max!=idx?max:-1;
	}
	
	public static void swap(int i,int j,int[] nums) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	
	}
	
	public static String getString(int[] nums) {
		StringBuilder s=new StringBuilder();
		for(int i :nums) {
			s.append(i);
		}
		return s.toString();
	}

}
