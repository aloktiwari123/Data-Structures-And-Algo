package sliding_Window;

public class countMaxVowels {
	
	public static void main(String args[]) {
		String s="abciiidef";
		System.out.print(solve(s,3));
	}
	
	public static int solve(String s,int k) {
		int i=0;
		int j=0;
		int max=0;
		int count=0;
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			if(arr[j]=='a'||arr[j]=='e'||arr[j]=='i'||arr[j]=='o'||arr[j]=='u')
			{
				count+=1;
			}
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				max=Math.max(max,count);
				if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u')
				{
					count-=1;
				}
				i++;
				j++;
			}
		}
		return max;
	}

}
