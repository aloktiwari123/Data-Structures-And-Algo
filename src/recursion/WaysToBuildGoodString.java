package recursion;

public class WaysToBuildGoodString {

	static int ans=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int low = 2;
		int high = 3;
		int zero = 1;
		int one = 2;
		generateString(low,high,0,zero,one);
		System.out.print(ans);
	}
	
	public static void generateString(int low,int high,int len,int zeros,int ones) {
		if(len>high) {
			return;
		}
		
		if(len>=low && len<=high) {
			ans=(int) (ans%(Math.pow(10,9) + 7));
			ans++;
		}
		
		generateString(low,high,len+zeros,zeros,ones); // select zeros
		generateString(low,high,len+ones,zeros,ones); // select ones
	}

}
