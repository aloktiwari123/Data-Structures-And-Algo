package TwoPointer;

public class PushDominoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dominoes = ".L.R...LR..L..";
		System.out.print(solve(dominoes));
	}
	
	public static String solve(String dominoes) {
		char[] charArr=dominoes.toCharArray();
		int n=charArr.length;
		int[] forces=new int[n];
		
		int force=0;
		
		// ---> left to right
		
		for(int i=0;i<n;i++) {
			if(charArr[i]=='R') force=n;
			else if(charArr[i]=='L') force=0;
			else force=Math.max(force-1, 0);
			forces[i]+=force;
		}
		
		// <--- right to left
		for(int i=n-1;i>=0;i--) {
			if(charArr[i]=='L') force=n;
			else if(charArr[i]=='R') force=0;
			else force=Math.max(force-1, 0);
			forces[i]-=force;
		}
		
        StringBuilder ans = new StringBuilder();
        for (int f: forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
	}

}
