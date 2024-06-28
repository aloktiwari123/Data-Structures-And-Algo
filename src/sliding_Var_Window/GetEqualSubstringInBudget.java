package sliding_Var_Window;

public class GetEqualSubstringInBudget {
	
	public static void main(String args[]) {
		String s = "fkfnkrfunni";
		String t = "jyufzxzfbsa";
		int maxCost = 18;
		System.out.print(solve(s,t,maxCost));
	}
	
	public static int solve(String s,String t,int budget) {
		int i=0;
		int j=0;
		int maxSum=0;
		int max=0;
		while(j<s.length()) {
			maxSum=maxSum+Math.abs(s.charAt(j)-t.charAt(j));
			
			if(maxSum<=budget) {
				max=Math.max(max,j-i+1);
				j++;
			}
			else if(maxSum>budget) {
				while(maxSum>budget) {
					maxSum=maxSum-Math.abs(s.charAt(i)-t.charAt(i));
					i++;
				}
				j++;
			}
			
		}
		return max;
		
	}

}
