package sliding_Window;

public class KBeautyofaNumber {
	
	public static void main(String args[]) {
	 System.out.println(KBeautyOfaNumber(430043,2));	
	}
	
	public static int KBeautyOfaNumber(int num ,int k){
		String s=Integer.toString(num);
		int i=0;
		int j=0;
		int count=0;
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			String temp=s.substring(i,j+1);
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				int val=Integer.valueOf(temp);
				if(val==0) {
					i++;
					j++;
					continue;
				}
				if(num%val==0) {
					count++;					
				}
				i++;
				j++;
			}
		}
		return count;
	}

}
