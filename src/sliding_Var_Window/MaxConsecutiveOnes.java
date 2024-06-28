package sliding_Var_Window;

public class MaxConsecutiveOnes {
	public static void main(String args[]) {
		int[] arr= {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		System.out.print(solve(arr,3));
	}
	
	public static int solve(int[] arr,int k) {
		int i=0;
		int j=0;
		int max=0;
		int count=0;
		while(j<arr.length) {
			if(arr[j]==1) {
				count+=1;
			}
			if(((j-i+1)-count)<=k){
				max=Math.max(j-i+1,max);
				j++;
			}
			else if(((j-i+1)-count)>k) {
				while(((j-i+1)-count)>k) {
					if(arr[i]==1) {
						count-=1;
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}

}
