package prefixSum;

public class SubStringScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1111";
		System.out.print(solve(s));
	}
	
	public static int solve(String s) {
		int[] sum=new int[s.length()];
		int temp=0;
		for(int i=0;i<s.length();i++) {
			temp+=s.charAt(i)-'0';
			sum[i]=temp;
		}
		int max=0;
		for(int i=0;i<s.length()-1;i++) {
			int zeros=(i+1)-sum[i];
			int ones=sum[s.length()-1]-sum[i];
			max=Math.max(zeros+ones,max);
		}
		return max;
	}

}
