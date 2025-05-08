package Trie.Bit.MaxXOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {3,10,5,25,2,8};
		//Trie trie=new Trie();
        //for(int n:nums){
        //    trie.insert(n);
        //}
        //int max=0;
        //for(int n:nums){
        //    max=Math.max(max,trie.getMax(n));
        //}
        //System.out.print(max);
		
		//3277. Maximum XOR Score Subarray Queries
		 int[] nums = {2,8,4,32,16,1}; 
		 int[][] queries = {{0,2},{1,4},{0,5}};
		 
		 ArrayList<ArrayList<Integer>> offlineQueries=new ArrayList<ArrayList<Integer>>();
		 
		 for(int i=0;i<queries.length;i++) {
			 ArrayList<Integer>list=new ArrayList<Integer>();
			 list.add(queries[i][0]);
			 list.add(queries[i][1]);
			 list.add(i);
			 offlineQueries.add(list);	 
		 }
		 
		 Arrays.sort(nums);
		 
		 Collections.sort(offlineQueries,new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(1).compareTo(o2.get(1));
			}		 
		 });
		 int len=queries.length;
		 ArrayList<Integer> ans=new ArrayList<>(len);
		 for(int i=0;i<len;i++) {
			 ans.add(-1);
		 }
		 int end=0;
		 Trie trie=new Trie();
		 for(int i=0;i<queries.length;i++) {
			 while(end<nums.length && nums[end]<=offlineQueries.get(i).get(1)) {
				 trie.insert(nums[end]);
				 end++;
			 }
			 int queryIdx=offlineQueries.get(i).get(2);
			 if(end!=0) ans.add(queryIdx,trie.getMax(offlineQueries.get(i).get(0)));
			 else ans.add(queryIdx,-1);
		 }
		 
		 System.out.print(ans);
	}

}
