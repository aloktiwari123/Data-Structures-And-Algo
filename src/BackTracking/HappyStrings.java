package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HappyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int k = 9;
		List<Character>choices=new ArrayList<Character>() {{
			add('a');
			add('b');
			add('c');
		}};
		List<String>list=new ArrayList<>();
		solve("", n, choices, list);
		Collections.sort(list);
		String reString="";
		System.out.println(list);
        if(list.size() >= k){
        	reString= list.get(k-1);
        }else{
        	reString= "";
        }
		System.out.println(reString);
	}
	
	public static void solve(String curr,int k,List<Character>choices,List<String>list) {
		if(k==0) {
			list.add(curr);
			return;
		}
		
		for(char ch:choices) {
			if(curr.length()==0) {
				curr+=ch;
				solve(curr, k-1, choices, list);
				curr=curr.substring(0,curr.length()-1);
			}else {
				if(curr.charAt(curr.length()-1)!=ch) {
					curr+=ch;
					solve(curr, k-1, choices, list);
					curr=curr.substring(0,curr.length()-1);
				}
			}
			
		}
	}

}
