package Sorting;

public class MaxSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=2736;
		System.out.print(solve(num));
	}
	
	public static int solve(int nums) {
		String str=Integer.toString(nums);
		int len=str.length();
		int max=nums;
		
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				char[] chars=str.toCharArray();
				char temp=chars[i];
				chars[i]=chars[j];
				chars[j]=temp;
				int tempNum = Integer.parseInt(new String(chars));
				max = Math.max(max, tempNum);
			}
		}
		return max;
	}

}
