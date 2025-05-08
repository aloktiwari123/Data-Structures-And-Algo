package DynamicPrograming;

public class TwoKeyBoard {

	static int n=3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(n==1) System.out.print(0);
		int res=1+solve(1,1);
		System.out.print(res);
		
		
	}
	
	public static int solve(int currlen,int pastelen) {
		if(currlen == n) return 0;
		
		if(currlen>n) return 1000;
		
		// copy all + paste
		int copy=2+solve(2*currlen,currlen);
		
		
		// paste
		int paste=1+solve(currlen+pastelen,pastelen);

		
		return Math.min(copy,paste);
	}

}
