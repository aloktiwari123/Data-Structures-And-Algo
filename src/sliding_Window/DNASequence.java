package sliding_Window;
import java.util.*;
public class DNASequence {
	
	public static void main(String args[]) {
		 //System.out.print(RepetativeDNA("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		 System.out.print(RepetativeDNA("AAAAAAAAAAAAA"));
	}
	
	public static List<String> RepetativeDNA(String s){
		int i=0,j=0;
		HashMap<String,Integer>map=new HashMap<>();
		char[] arr=s.toCharArray();
		List<String> list=new ArrayList<>();
		while(j<arr.length) {
			//String temp=s.substring(i, j+1)
			if((j-i+1)<10) {
				j++;
			}
			else if((j-i+1)==10) {
				String temp=s.substring(i, j+1);
				map.put(temp,map.getOrDefault(temp,0)+1);
				if(map.get(temp)==2) {
					list.add(temp);
				}
				i++;
				j++;
			}
		}
		
		return list;
	}

}
