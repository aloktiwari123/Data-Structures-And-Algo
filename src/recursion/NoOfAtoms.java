package recursion;
import java.util.*;
public class NoOfAtoms {

	static int idx=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="K4(ON(SO3)2)2";
		String s="Mg(OH)2";
		System.out.print(solve(s));
	}
	
	
	public static HashMap<String,Integer> solve(String s){
		HashMap<String,Integer> currMap=new HashMap<>();
		String currAtom=new String();
		String currCount=new String();
		
		while(idx<s.length()) {
			char ch=s.charAt(idx);
			
			if(Character.isUpperCase(ch)) {
				if(!currAtom.isEmpty()) {
					if(currCount.isEmpty()) {
						currMap.put(currAtom,currMap.getOrDefault(currAtom, 0) + 1);
					}
					else {
						currMap.put(currAtom,currMap.getOrDefault(currAtom, 0) + Integer.parseInt(currCount));
					}
				}
				currAtom=String.valueOf(ch);
				currCount="";
				idx++;
			}
			else if(Character.isLowerCase(ch)) {
				currAtom+=ch;
				idx++;
			}
			else  if(Character.isDigit(ch)) {
				currCount+=ch;
				idx++;
			}
			else if(ch=='(') {
				idx++;
				Map<String,Integer> temp=solve(s);
				for(String atom:temp.keySet()) {
					currMap.put(atom,currMap.getOrDefault(atom,0)+temp.get(atom));
				}
				
			}
			else if(ch==')') {
				if(!currAtom.isEmpty()) {
					if(currCount.isEmpty()) {
						currMap.put(currAtom,currMap.getOrDefault(currAtom, 0) + 1);
					}
					else {
						currMap.put(currAtom,currMap.getOrDefault(currAtom, 0) + Integer.parseInt(currCount));
					}
				}
				idx++;
				StringBuilder cardinal=new StringBuilder();
				while(idx<s.length() && Character.isDigit(s.charAt(idx))) {
					cardinal.append(s.charAt(idx));
					idx++;
				}
				if(cardinal.length()>0) {
					int multiplier=Integer.parseInt(cardinal.toString());
					 for (String atom : currMap.keySet()) {
	                        currMap.put(atom, currMap.get(atom) * multiplier);
	                  }
				}
				
				return currMap;
			}
		}
		
		// handling non bracket cases
		if(!currAtom.isEmpty()) {
			if(currCount.isEmpty()) {
				currMap.put(currAtom,currMap.getOrDefault(currAtom, 0) + 1);
			}
			else {
				currMap.put(currAtom,currMap.getOrDefault(currAtom, 0) + Integer.parseInt(currCount));
			}
		}
		
		
		return currMap;
		
	}

}
