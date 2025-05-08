package BackTracking;

public class MaxBitWise {

	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,2,2};
        int max=0;
        for(int num:nums){
            max=max|num;
        }
		solve(0,nums,max,0);
		System.out.print(count);
	}
	
	public static void solve(int idx,int arr[],int max,int or) {
		
		if(idx==arr.length) {
			if(or==max) count++;
			return;
		}
		
		solve(idx+1,arr,max,or|arr[idx]);
		solve(idx+1,arr,max,or);
	}

}
