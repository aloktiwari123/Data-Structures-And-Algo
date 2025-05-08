package HashFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s1 = "this apple is sweet";
		 String s2 = "this apple is sour";
		 uncommonFromSentences(s1,s2);
	}
	
	 public static String[] uncommonFromSentences(String s1, String s2) {
         HashMap<String,Integer> map=new HashMap<>();
         StringBuilder st=new StringBuilder(s1);
         st.append(" ");
         st.append(s2);
         String[] arr1=st.toString().split(" ");
         for(String s:arr1){
             map.put(s,map.getOrDefault(s,0)+1);
         }
         List<String>list=new ArrayList<>();
        for(Map.Entry<String,Integer>entry:map.entrySet()) {
        	if(entry.getValue()==1) {
        		list.add(entry.getKey());
        	}
        }
	     System.out.print(list);
         String[] str=new String[list.size()];
         for(int i=0;i<list.size();i++){
             str[i]=list.get(i);
         }
	        return str;
	    }

}
