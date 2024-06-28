package sliding_Var_Window;
public class LongestRepeatingCharacterReplacement {
	
	public static void main(String args[]) {
		System.out.println(characterReplacement("AABABBA",1));
	}
	
	 public static int characterReplacement(String s, int k) {
		 int i=0,j=0;
		 int max=0;
		 int max_freq=0;
		 int []frq = new int[26];
		 char[] arr=s.toCharArray();
		 
		 while(j<arr.length) {
			 frq[arr[j]-'A']++;
			 max_freq=Math.max(frq[arr[j]-'A'], max_freq);
			 if(((j-i+1)-max_freq)<k) {
				 max=Math.max(max,(j-i+1));
				 j++;
			 }
			 else if(((j-i+1)-max_freq)==k) {
				 max=Math.max(max,(j-i+1));
				 j++;
			 }
			 else if(((j-i+1)-max_freq)>k) {
				 while(((j-i+1)-max_freq)>k){
					 frq[arr[i]-'A']--;
					 i++;
				 }
				 j++;
			 }
		 }
		 
		 return max;
	        
	    }

}
