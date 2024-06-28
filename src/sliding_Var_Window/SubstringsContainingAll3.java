package sliding_Var_Window;
import java.util.*;
public class SubstringsContainingAll3 {
	
	public static void main(String args[]) {
		System.out.print(solve("abcabc",3)-solve("abcabc",2));
	}
	
    public static int solve(String s, int k) {
        int count=0;
		int i=0,j=0;
		HashMap<Character,Integer> map= new HashMap<>();
		char[] arr=s.toCharArray();
		while(j<arr.length) {
			map.put(arr[j],map.getOrDefault(arr[j],0)+1);
			if(map.size()<=k) {
				count+=(j-i+1);
				j++;
			}
			else if(map.size()>k) {
				while(map.size()>k) {
					map.put(arr[i],map.get(arr[i])-1);
					if(map.get(arr[i])==0) {
						map.remove(arr[i]);
					}
					i++;
				}
				count+=(j-i+1);
				j++;
			}
			
			}
		return count;
    }

}
