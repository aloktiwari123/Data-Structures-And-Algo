package BackTracking;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> sequences = new HashSet<>();
		String tiles="AAB";
        int len = tiles.length();
        boolean[] used = new boolean[len];

        // Generate all possible sequences including empty string
        // generateSequences(tiles, "", used, sequences);

        // Subtract 1 to exclude empty string from count
        solve("", tiles, sequences);
        System.out.println(sequences);
        System.out.println(sequences.size()-1);
	}
	
//	 public static void generateSequences(
//		        String tiles,
//		        String current,
//		        boolean[] used,
//		        Set<String> sequences
//		    ) {
//		        // Add current sequence to set
//		        sequences.add(current);
//
//		        // Try adding each unused character to current sequence
//		        for (int pos = 0; pos < tiles.length(); pos++) {
//		            if (!used[pos]) {
//		                used[pos] = true;
//		                generateSequences(
//		                    tiles,
//		                    current + tiles.charAt(pos),
//		                    used,
//		                    sequences
//		                );
//		                used[pos] = false;
//		            }
//		        }
//		    }
	
	public static void solve(String curr,String inUse,Set<String>set) {
		set.add(curr);
		if(inUse=="") {
			return;
		}
		
		for(int i=0;i<inUse.length();i++) {
			char ch=inUse.charAt(i);
			curr=curr+ch;
			String newInUse= inUse.substring(0,i)+inUse.substring(i+1,inUse.length());
			solve(curr, newInUse, set);
			curr=curr.substring(0,curr.length()-1);
		}
	}

}
