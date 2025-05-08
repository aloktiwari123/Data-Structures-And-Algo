package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AllBinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>list=new ArrayList<>();
		solve(list,"", 3);
		String[] nums = {"111","011","001"};
		HashSet<String>set=Arrays.stream(nums).collect(Collectors.toCollection(()->new HashSet<>()));
		System.out.println(list);
		for(String s:list){
            if(!set.contains(s)){
                System.out.println(s);
                break;
            }
        }
        System.out.println("");
	}
	
	public static void solve(List<String>list,String curr,int k) {
		if(k==0) {
			list.add(curr);
			return;
		}
		
		for(int i=0;i<=1;i++) {
			curr+=(char)(i+'0');
			solve(list, curr, k-1);
			curr=curr.substring(0,curr.length()-1);
		}
	}

}
