package Graph;

import java.util.*;

public class WordLadder {

	public static void main(String args[]) {
		String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };
        System.out.print(shortestPath(startWord,targetWord,wordList));
	}
	
	public static int shortestPath(String startWord,String endWord,String[] wordList) {
		HashSet<String>set=new HashSet<>();
		for(String s:wordList) {
			set.add(s);
		}
		Queue<dis>queue=new LinkedList<>();
		queue.add(new dis(startWord,1));
		set.remove(startWord);
		while(!queue.isEmpty()) {
			dis node=queue.poll();
			String s=node.s;
			int count=node.n;
			if(s.equals(endWord)){
				return count;
			}
			for(int i=0;i<s.length();i++) {
				for(char ch='a';ch<='z';ch++) {
					char[] temp=s.toCharArray();
					temp[i]=ch;
					String tempString= new String(temp);
					if(set.contains(tempString)) {
						queue.add(new dis(tempString,count+1));
						set.remove(tempString);
					}
				}
			}
		}
		return 0;
	}
}

class dis{
	String s;
	int n;
	
	dis(String s,int n){
		this.s=s;
		this.n=n;
	}
}
