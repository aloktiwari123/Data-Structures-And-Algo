package Graph;
import java.util.*;
public class WordLadderII {
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

	private static List<List<String>> shortestPath(String startWord, String targetWord, String[] wordList) {
		HashSet<String>set=new HashSet<>();
		List<List<String>>ans=new ArrayList<>();
		for(String s:wordList) {
			set.add(s);
		}
		int level=0;
		Queue<List<String>>queue=new LinkedList<>();
		List<String>usedOnLevel=new ArrayList<>();
		List<String>list=new ArrayList<>();
		list.add(startWord);
		usedOnLevel.add(startWord);
		queue.add(list);
		set.remove(startWord);
		while(!queue.isEmpty()) {
			List<String> nodes=queue.poll();
			String word=nodes.get(nodes.size()-1);
			if(nodes.size()>level) {
				level++;
				set.removeAll(usedOnLevel);
				usedOnLevel.clear();
			}
			if(word.equals(targetWord)){
				if(ans.size()==0) ans.add(nodes);
				else if(ans.get(0).size()==nodes.size()) ans.add(nodes);
			}
			for(int i=0;i<word.length();i++) {
				for(char ch='a';ch<='z';ch++) {
					char[] temp=word.toCharArray();
					temp[i]=ch;
					String tempString= new String(temp);
					if(set.contains(tempString)) {
						usedOnLevel.add(tempString);
						List<String>tempList=new ArrayList<>(nodes);
						tempList.add(tempString);
						queue.add(tempList);
					}
				}
			}
			
		}
		return ans;
	}
	
}
