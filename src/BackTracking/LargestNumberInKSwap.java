package BackTracking;
public class LargestNumberInKSwap {

	public static void main(String args[]) {
		String s="4577";
		Long n=solve(0,s.length(),s,3);
		System.out.print(n);
	}
	
	public static Long solve(int start,int end,String s,int k) {
		if(start==end || k==0) {
			return Long.valueOf(s);
		}
		int max=getMax(start,s);
		Long maxValue=(long) -1;
		if(max!=-1) {
			for(int i=start+1;i<end;i++) {
				if((s.charAt(i)-'0')==max) {
					s=swap(start,i,s);
					maxValue=Math.max(maxValue,solve(start+1,end,s,k-1));
					s=swap(start,i,s);
				}
			}
		}
		else {
			maxValue=Math.max(maxValue,solve(start+1,end,s,k));
		}
		return maxValue;
		
	}
	public static int getMax(int start,String s) {
		int max=s.charAt(start)-'0';
		for(int i=start;i<s.length();i++) {
			max=Math.max(s.charAt(i)-'0',max);
		}
		return max!=s.charAt(start)-'0'?max:-1;
	}
	
	public static String swap(int i,int j,String s) {
		char[] arr=s.toCharArray();
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		return String.valueOf(arr);
	}
	
	
}
