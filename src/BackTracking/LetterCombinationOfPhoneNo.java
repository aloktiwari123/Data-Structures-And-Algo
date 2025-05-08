package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNo {

	static HashMap<Integer,List<Character>>keyPad=new HashMap<Integer,List<Character>>();
	static List<String>ans=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getKeyPad();
		solve("","");
		System.out.print(ans);
	}
	
	public static void getKeyPad() {
		keyPad.put(2,new ArrayList<Character>() {{add('a');add('b');add('c');}});
		keyPad.put(3,new ArrayList<Character>() {{add('d');add('e');add('f');}});
		keyPad.put(4,new ArrayList<Character>() {{add('g');add('h');add('i');}});
		keyPad.put(5,new ArrayList<Character>() {{add('j');add('k');add('l');}});
		keyPad.put(6,new ArrayList<Character>() {{add('m');add('n');add('o');}});
		keyPad.put(7,new ArrayList<Character>() {{add('p');add('q');add('r');add('s');}});
		keyPad.put(8,new ArrayList<Character>() {{add('t');add('u');add('v');}});
		keyPad.put(9,new ArrayList<Character>() {{add('w');add('x');add('y');add('z');}});
	}
	
	public static void solve(String ip,String op) {
		if(ip.length() == 0) {
			if(!op.isEmpty()) ans.add(op);
			return;
		}
		
		int currChar=ip.charAt(0)-'0';
		
		for(char ch:keyPad.get(currChar)) {
			String new_ip=ip.substring(0,0)+ip.substring(1,ip.length());
			solve(new_ip,op+ch);
		}
		
		
	}

}
