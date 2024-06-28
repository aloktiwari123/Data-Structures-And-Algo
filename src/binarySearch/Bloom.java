package binarySearch;

public class Bloom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bloomDay = {1,10,3,10,2};
		int m = 3;
		int k = 1;
		System.out.print(solve(bloomDay,k,m));
	}
	
	public static int solve(int[] bloom,int k,int m) {
		int start=0;
		int end=0;
		for(int n:bloom) {
			end=Math.max(n,end);
		}
		
		int minDays=-1;
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(getBookeys(bloom,mid,k)>=m) {
				minDays=mid;
				end=mid-1;
			}else {
				start=mid+1;
			}
			
		}
		return minDays;
	}
	
	public static int getBookeys(int[] bloom,int mid,int k) {
		int count=0;
		int numOfBookey=0;
		
		for(int i=0;i<bloom.length;i++) {
			if(bloom[i]<=mid) {
				count++;
			}
			else {
				count=0;
			}
			
			if(count==k) {
				numOfBookey++;
				count=0;
			}
		}
		return numOfBookey;
	}

}
