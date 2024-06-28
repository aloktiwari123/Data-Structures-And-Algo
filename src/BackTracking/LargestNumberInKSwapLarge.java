package BackTracking;

public class LargestNumberInKSwapLarge {

	static String max;
	public static void main(String args[]) {
		String s="4577";
		max=s;
		solve(0,s.length(),s,2);
		System.out.print(max);
	}
	
	public static void solve(int start,int end,String s,int k) {
		if(s.compareTo(max)>0) {
			max=s;
		}
		if(start==end || k==0) {
			return ;
		}
		int maxN=getMax(start,s);
		if(maxN!=-1) {
			for(int i=start+1;i<end;i++) {
				if((s.charAt(i)-'0')==maxN) {
					s=swap(start,i,s);
					solve(start+1,end,s,k-1);
					s=swap(start,i,s);
				}
			}
		}
		else {
			solve(start+1,end,s,k);
		}

		
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
