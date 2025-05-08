package HashFunction;
import java.util.*;
public class SortByMap {
 
	static int[] mapping;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mapping =new int[] {8,9,4,0,2,1,3,5,7,6};
		int[] nums = {991,338,38};
		map[] vals=new map[nums.length];
		for(int i=0;i<nums.length;i++) {
			vals[i]=new map(convert(nums[i]),nums[i]);
		}
		Arrays.sort(vals);
		
		for(int i=0;i<nums.length;i++) {
			System.out.println(vals[i]);
		}
	}
	
	
	public static int convert(int num) {
		StringBuilder str=new StringBuilder();
		for(char ch:String.valueOf(num).toCharArray()) {
			int val=ch-'0';
			str.append(mapping[val]);
		}
		return Integer.valueOf(str.toString());
	}
	
	

}

class map implements Comparable<map>{
	int mapping;
	int num;
	
	public map(int mapping,int num) {
		this.mapping=mapping;
		this.num=num;
	}

	@Override
	public int compareTo(map o) {
		// TODO Auto-generated method stub
		int c1=o.mapping;
		int c2=mapping;
		return Integer.compare(c2,c1);
	}

	@Override
	public String toString() {
		return "map [num=" + num + "]";
	}
	
	
}

