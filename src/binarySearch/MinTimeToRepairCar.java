package binarySearch;

public class MinTimeToRepairCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ranks = {4,2,3,1};
		int cars = 10;
		System.out.println(solve(ranks, cars));
	}
	
	 public static long solve(int[] ranks,int cars) {
			long right=Long.MAX_VALUE;
			for(int rank:ranks) {
				right=Math.min(rank, right);
			}
			long left=1;
			right=1L*cars*cars*right;
			long result=right;
			
			while(left<=right) {
				long mid=left+(right-left)/2;
				
				if(isPossible(mid,ranks,cars)) {
					result=mid;
					right=mid-1;
				}else {
					left=mid+1;
				}
			}
			return result;
	}
		
	public static boolean isPossible(long k,int[] ranks,int cars) {
		long minCars=0;
		for(int rank:ranks) {
			minCars+=(long)Math.sqrt(k/(long)rank);
		}
		return minCars>=cars;
	}


}
