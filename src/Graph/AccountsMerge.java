package Graph;
import java.util.*;
public class AccountsMerge {
	
	public static void main(String args[]) {
		int N = 6;
		List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };
		System.out.print(solve(accounts,N));
	}
	
	public static List<List<String>> solve(List<List<String>> accounts,int n){
		DisjointSet set=new DisjointSet(n);
		List<List<String>> list=new ArrayList<>();
		HashMap<String,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			for(int j=1;j<accounts.get(i).size();j++) {
				String key=accounts.get(i).get(j);
				if(map.containsKey(key)) {
					set.unionBySize(map.get(key), i);
				}
				else {
					map.put(key,i);
				}
			}
		}
		List<List<String>> merged=new ArrayList<>();
		for (int i = 0; i < n; i++) {
			merged.add(new ArrayList<String>());
		}
		for(Map.Entry<String,Integer>entry:map.entrySet()) {
			int uP=set.findUParent(entry.getValue());
			merged.get(uP).add(entry.getKey());
		}
		for (int i = 0; i < n; i++) {
            if (merged.get(i).size() == 0) continue;
            Collections.sort(merged.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : merged.get(i)) {
                temp.add(it);
            }
            list.add(temp);
        }
		return list;
	}

}
