package prefixSum;

public class ShiftingLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
		System.out.print(solve(s,shifts));
	}
	
	public static String solve(String s,int[][] shifts) {
		char[] chars=s.toCharArray();
		int[] diffArray=new int[s.length()];
		int n=s.length();
		
		for(int[] shift:shifts) {
			
			if(shift[2]==1) {
				diffArray[shift[0]]++;
				if(shift[1]+1<n) {
					diffArray[shift[1]+1]--;
				}
				
			}else {
				diffArray[shift[0]]--;
				if(shift[1]+1<n) {
					diffArray[shift[1]+1]++;
				}
			}
			
		}
		
		int noOfShifts=0;
		for(int i=0;i<n;i++) {
			noOfShifts=(noOfShifts+diffArray[i])%26;
			
			if(noOfShifts<0) {
				noOfShifts+=26;
			}
			
			chars[i]=(char)('a'+(chars[i]-'a'+noOfShifts)%26);
		}
		
		return new String(chars);
	}

}
