package Greedy;

public class LemonadeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bills = {5,5,5,5,20,20,5,5,20,5};
		System.out.print(solve(bills));
	}
	
	public static boolean solve(int[] bills) {
		int fiveBills=0;
		int tenBills=0;
		
		for(int bill:bills) {
			if(bill==5) {
				fiveBills++;
			}
			else if(bill==10) {
				if(fiveBills>0) {
					fiveBills--;
					tenBills++;
				}else {
					return false;
				}
					
			}
			else {
				if(fiveBills>0 && tenBills>0) {
					fiveBills--;
					tenBills--;
				}else if(fiveBills>3) {
					fiveBills-=3;
				}else {
					return false;
				}
			}
		}
		return true;
	}

}
